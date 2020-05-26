package lec.spring.layered.services;

import lec.spring.layered.dao.GuestBookDao;
import lec.spring.layered.dao.LogDao;
import lec.spring.layered.dto.GuestBook;
import lec.spring.layered.dto.Log;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={lec.spring.layered.config.ApplicationConfig.class})
public class GuestBookServiceImpTest {

    @Autowired
    GuestBookService guestBookService;

    @Autowired
    GuestBookDao guestBookDao;

    @Autowired
    LogDao logDao;

    @Test
    @Transactional
    public void deleteGustBook() {
        int before = guestBookDao.selectCount();
        int beforeLog = Math.max(logDao.selectCount(), 0);
        guestBookService.deleteGustBook( guestBookDao.selectAll(0, 9999).get(0).getId() , "127.0.0.1");
        Assert.assertEquals(before - 1, guestBookDao.selectCount());
        Assert.assertEquals(beforeLog + 1, logDao.selectCount());
    }

    @Test
    @Transactional
    public void addGuestBook() {
        int before = guestBookDao.selectCount();
        int beforeLog = Math.max(logDao.selectCount(), 0);

        GuestBook guestBook = new GuestBook();
        guestBook.setName("monday");
        guestBook.setContent("TEST");
        GuestBook result = guestBookService.addGuestBook( guestBook, "127.0.0.1");

        Assert.assertEquals(before + 1, guestBookDao.selectCount());
        Assert.assertEquals(beforeLog + 1, logDao.selectCount());
        Assert.assertEquals(guestBook, result);

        System.out.println(guestBook.toString());
        System.out.println(result.toString());
    }
}