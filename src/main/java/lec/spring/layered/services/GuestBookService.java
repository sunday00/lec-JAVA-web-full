package lec.spring.layered.services;

import lec.spring.layered.dto.GuestBook;

import java.util.List;

public interface GuestBookService {
    public static final int LIMIT = 5;
    public List<GuestBook> getGuestBooks(Integer start);
    public int deleteGustBook(Long id, String ip);
    public GuestBook addGuestBook(GuestBook guestBook, String ip);
    public int getCount();
}
