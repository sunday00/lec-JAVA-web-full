package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Promotion;
import lec.sunday00.reservation.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PromotionService implements PromotionServiceInterface {

    @Autowired
    PromotionRepository promotionRepository;

    public List<Promotion> selectAll () {
        return promotionRepository.selectAll();
    }

}
