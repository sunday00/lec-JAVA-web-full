package lec.sunday00.reservation.controller;

import lec.sunday00.reservation.model.Comment;
import lec.sunday00.reservation.service.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comment")
public class ApiCommentController {

    @Autowired
    CommentServiceInterface commentServiceInterface;

    @GetMapping("/score/{id}")
    public Map score (@PathVariable (name = "id") Long id) {
        return commentServiceInterface.score(id);
    }

    @GetMapping("/brief/{id}")
    public List<Comment> briefList (@PathVariable (name = "id") Long id) {
        return commentServiceInterface.select3(id);
    }
}
