package lec.spring.layered.controllers;

import lec.spring.layered.dto.GuestBook;
import lec.spring.layered.services.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestBookController {

    @Autowired
    GuestBookService guestBookService;

    @GetMapping("/list")
    public String list(@RequestParam(name = "start", required = false, defaultValue = "0") int start, ModelMap modelMap) {
        List<GuestBook> list = guestBookService.getGuestBooks(start);

        int count = guestBookService.getCount();
        int pageCount = count / GuestBookService.LIMIT;
        if( count % GuestBookService.LIMIT > 0 ) pageCount++;

        List<Integer> pageList = new ArrayList<>();
        for(int i=0; i<pageCount; i++){
            pageList.add(i * GuestBookService.LIMIT);
        }

        modelMap.addAttribute("list", list);
        modelMap.addAttribute("count", count);
        modelMap.addAttribute("pageStartList", pageList);

        return "list";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute GuestBook guestBook,
                        HttpServletRequest request) {
        guestBookService.addGuestBook(guestBook, request.getRemoteAddr());
        return "redirect:list";
    }
}
