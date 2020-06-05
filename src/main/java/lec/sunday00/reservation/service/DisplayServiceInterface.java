package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Display;

import java.util.List;

public interface DisplayServiceInterface {
    public int selectCount (String category);
    public List<Display> select(String category, int page);
    public Display selectOne(int id);
}
