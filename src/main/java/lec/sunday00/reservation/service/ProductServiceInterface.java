package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Product;

import java.util.List;

public interface ProductServiceInterface {
    public int selectCount (String category);
    public List<Product> select(String category, int page);
}
