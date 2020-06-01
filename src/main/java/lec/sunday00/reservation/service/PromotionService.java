package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Product;
import lec.sunday00.reservation.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService implements PromotionServiceInterface {

    @Autowired
    PromotionRepository promotionRepository;

    public List<Product> selectAll () {
        return promotionRepository.selectAll();
    }

}
