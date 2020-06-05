package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Display;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {lec.sunday00.reservation.config.ApplicationConfig.class})
public class DisplayRepositoryTest {

    @Autowired
    DisplayRepository displayRepository;

    @Test
    public void selectOne() {

        Display display = displayRepository.selectOne(1);

        System.out.println(display);

        Assert.assertEquals(display.getId().longValue(), 1);

    }
}