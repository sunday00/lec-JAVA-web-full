package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Product;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

import static lec.sunday00.reservation.repository.PromotionSql.*;

@Repository
public class PromotionRepository extends BaseRepository{

    public PromotionRepository(DataSource dataSource, Product promotion) {
        super(dataSource, promotion, "promotion");
    }

    public List<Product> selectAll (){
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), this.rowMapper);
    }
}
