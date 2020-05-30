package lec.sunday00.reservation.controller;

import lec.sunday00.reservation.model.Promotion;
import lec.sunday00.reservation.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/promotion")
public class ApiPromotionController {

    @Autowired
    PromotionRepository promotionRepository;

    @GetMapping("/{category}")
    public List<Promotion> index (@PathVariable(name = "category") String category, HttpServletRequest request) {
        if( category.equals("all") ){
            return promotionRepository.selectAll();
        }

        return null;
    }

}
