package lec.sunday00.reservation.controller;

import lec.sunday00.reservation.model.Category;
import lec.sunday00.reservation.service.CategoryServiceInterface;
import lec.sunday00.reservation.service.PromotionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {

    @Autowired
    CategoryServiceInterface categoryServiceInterface;

    @GetMapping("/list")
    public List<Category> index () {
        return categoryServiceInterface.selectAll();
    }

}
