package lec.sunday00.reservation.controller;

import lec.sunday00.reservation.model.Product;
import lec.sunday00.reservation.service.ProductService;
import lec.sunday00.reservation.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ApiProductController {

    @Autowired
    ProductServiceInterface productServiceInterface;

    @GetMapping("/count/{category}")
    public int selectCount( @PathVariable(name = "category") String category ){
        return productServiceInterface.selectCount(category);
    }

    @GetMapping("/{category}/{page}")
    public List<Product> select ( @PathVariable(name = "category") String category,
                                  @PathVariable(name = "page", required = false) Integer page ) {

        if( page == null ) page = 1;
        return productServiceInterface.select(category, page);
    }
}
