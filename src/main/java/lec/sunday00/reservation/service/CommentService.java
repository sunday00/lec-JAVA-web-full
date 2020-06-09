package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Comment;
import lec.sunday00.reservation.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService implements CommentServiceInterface {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Map score(Long id) {
        return commentRepository.score(id);
    }

    @Override
    public List<Comment> selectAll(Long id, int page) {
        return commentRepository.selectAll(id, page);
    }

    @Override
    public List<Comment> select3(Long id) {
        return commentRepository.select3(id);
    }
}
