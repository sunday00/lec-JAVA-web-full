package lec.spring.layered.services;

import lec.spring.layered.dto.GuestBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookServiceImp implements GuestBookService{
    @Override
    public List<GuestBook> getGuestBooks(Integer start) {
        return null;
    }

    @Override
    public int deleteGustBook(Long id, String ip) {
        return 0;
    }

    @Override
    public GuestBook addGuestBook(GuestBook guestBook, String ip) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
