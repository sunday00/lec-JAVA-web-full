package lec.spring.layered.services;

import lec.spring.layered.dao.GuestBookDao;
import lec.spring.layered.dao.LogDao;
import lec.spring.layered.dto.GuestBook;
import lec.spring.layered.dto.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuestBookServiceImp implements GuestBookService{
    @Autowired
    GuestBookDao guestBookDao;

    @Autowired
    LogDao logDao;

    @Override
    @Transactional
    public List<GuestBook> getGuestBooks(Integer start) {
        return guestBookDao.selectAll(start, GuestBookService.LIMIT);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteGustBook(Long id, String ip) {
        int result = 0;
        result = guestBookDao.deleteById(id);
        Log log = new Log();
        log.setId(id);
        log.setIp(ip);
        log.setMethod("delete");
        logDao.insert(log);
        return result;
    }

    @Override
    @Transactional(readOnly = false)
    public GuestBook addGuestBook(GuestBook guestBook, String ip) {
        Long id = guestBookDao.insert(guestBook);
        guestBook.setId(id);

        Log log = new Log();
        log.setId(id);
        log.setIp(ip);
        log.setMethod("insert");
        logDao.insert(log);

        return guestBook;
    }

    @Override
    @Transactional
    public int getCount() {
         return guestBookDao.selectCount();
    }
}
