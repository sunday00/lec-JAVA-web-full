package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Product;
import lec.sunday00.reservation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;

    @Override
    public int selectCount(String category) {
        return productRepository.selectCount(category);
    }

    @Override
    public List<Product> select(String category, int page) {
        return productRepository.select(category, page);
    }
}
