package lec.spring.layered.controllers;

import lec.spring.layered.dto.GuestBook;
import lec.spring.layered.services.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/guestbook")
public class RestGuestBookController {

    @Autowired
    GuestBookService guestBookService;

    @GetMapping("/")
    public Map<String, Object> list (@RequestParam(name = "start", defaultValue = "0", required = false) int start) {
        List <GuestBook> list = guestBookService.getGuestBooks(start);
        int count = guestBookService.getCount();
        int pageCount = count / GuestBookService.LIMIT;
        if( count % GuestBookService.LIMIT > 0 ) pageCount++;

        List<Integer> pageList = new ArrayList<>();
        for(int i=0; i<pageCount; i++){
            pageList.add(i * GuestBookService.LIMIT);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("count", count);
        result.put("pageStartList", pageList);

        return result;
    }

    @PostMapping("/")
    public GuestBook store(@RequestBody GuestBook guestBook, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        return guestBookService.addGuestBook(guestBook, ip);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete (@PathVariable (name = "id") Long id, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        int result = guestBookService.deleteGustBook(id, ip);
        return Collections.singletonMap("success", result > 0 ? "true" : "false");
    }
}
