package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Category;
import lec.sunday00.reservation.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> selectAll() {
        return categoryRepository.selectAll();
    }
}
