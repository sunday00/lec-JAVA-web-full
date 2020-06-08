package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {lec.sunday00.reservation.config.ApplicationConfig.class})
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void commentRepositoryScoreTest () {
        Map<String, Long> data = commentRepository.score(Long.parseLong("1"));
        System.out.println(data);
        Assert.assertTrue(data.containsKey("cnt"));
        Assert.assertTrue(data.containsKey("avg"));
    }

    @Test
    public void commentRepositorySelect3Test () {
        List<Comment> data = commentRepository.select3(Long.parseLong("1"));
        System.out.println(data);
    }

}