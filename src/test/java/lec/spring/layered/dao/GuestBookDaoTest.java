package lec.spring.layered.dao;

import lec.spring.layered.dto.GuestBook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={lec.spring.layered.config.ApplicationConfig.class})
public class GuestBookDaoTest {

    @Autowired
    GuestBookDao guestBookDao;

    @Test
    public void selectAll() {
        List<GuestBook> list = guestBookDao.selectAll(0, 9999);
        Assert.assertEquals(list.size(), guestBookDao.selectCount());
        Assert.assertNotNull(list.get(list.size() - 1));
        System.out.println( list.get(list.size() - 1).getName() );
    }

    @Test
    @Transactional
    public void insert() {
        GuestBook guestBook = new GuestBook();
        int before = guestBookDao.selectCount();
        guestBook.setName("monday");
        guestBook.setContent("hello test");
        guestBookDao.insert(guestBook);
        int now = guestBookDao.selectCount();
        Assert.assertEquals(before + 1, now);
    }

    @Test
    @Transactional
    public void deleteById() {
        int before = guestBookDao.selectCount();
        System.out.println(before);
        guestBookDao.deleteById(guestBookDao.selectAll(0, 999).get(guestBookDao.selectAll(0, 999).size() - 1).getId());
        int now = guestBookDao.selectCount();
        System.out.println(now);
        Assert.assertEquals(before - 1, now);
    }
}