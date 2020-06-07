package lec.sunday00.reservation.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        Assert.assertTrue(data.containsKey("cnt"));
        Assert.assertTrue(data.containsKey("avg"));
    }

}