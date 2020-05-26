package lec.spring.layered.dao;

import lec.spring.layered.config.ApplicationConfig;
import lec.spring.layered.dto.GuestBook;
//import org.junit.Assert;
//import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={lec.spring.layered.config.ApplicationConfig.class})
@TransactionConfiguration(defaultRollback=true)
public class GuestBookDaoTest {

    public GuestBookDao getGuestBookDao () {
        return (new AnnotationConfigApplicationContext(ApplicationConfig.class)).getBean(GuestBookDao.class);
    }

    @Test
    public void selectAll() {
        GuestBookDao guestBookDao = getGuestBookDao();
        List<GuestBook> selectAll = guestBookDao.selectAll(0, 999);
        int cnt = guestBookDao.selectCount();
        Assert.hasText(String.valueOf(selectAll.size()), String.valueOf(cnt));
        System.out.println(selectAll.get(0).getName());
    }

    @Test
    @Transactional
    @Rollback
    public void insert() {
        GuestBookDao guestBookDao = getGuestBookDao();
        GuestBook guestBook = new GuestBook();
        int now = guestBookDao.selectCount();
        guestBook.setName("monday");
        guestBook.setContent("hello test");
        Long result = guestBookDao.insert(guestBook);
        Assert.hasText(Long.valueOf(now + 1).toString(), result.toString());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteById() {
        GuestBookDao guestBookDao = getGuestBookDao();
        int before = guestBookDao.selectCount();
        System.out.println(before);
        Long id = guestBookDao.selectAll(0,999).get(guestBookDao.selectCount() - 1).getId();
        guestBookDao.deleteById(id);
        int now = guestBookDao.selectCount();
        Assert.hasText(String.valueOf(before - now), String.valueOf(1));
        System.out.println(now);
    }
}