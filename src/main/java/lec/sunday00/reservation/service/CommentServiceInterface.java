package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentServiceInterface {
    public List<Comment> select3(Long id);
    Map score(Long id);
}
