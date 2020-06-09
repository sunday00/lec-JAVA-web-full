package lec.sunday00.reservation.controller;

import lec.sunday00.reservation.model.Comment;
import lec.sunday00.reservation.model.Display;
import lec.sunday00.reservation.repository.CommentRepository;
import lec.sunday00.reservation.repository.DisplayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/display/show/review")
public class WebCommentController {

    @Autowired
    DisplayRepository displayRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/{id}")
    public String index (@PathVariable(name = "id") int id,
                         @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                         ModelMap modelMap) {

        Display display = displayRepository.selectOne(id);
        List<Comment> list = commentRepository.selectAll(Long.parseLong(String.valueOf(id)), page);
        Map count = commentRepository.score(Long.parseLong(String.valueOf(id)));

        modelMap.addAttribute("id", id);
        modelMap.addAttribute("display", display);
        modelMap.addAttribute("comment", list);
        modelMap.addAttribute("count", count);

        return "comment";
    }
}
