package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Product;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lec.sunday00.reservation.repository.ProductSql.*;

@Repository
public class ProductRepository extends BaseRepository {
    public ProductRepository(DataSource dataSource, Product object) {
        super(dataSource, object, "product");
    }

    public int selectCount(String category){
        if ( category.equals("all") ){
            return this.jdbc.queryForObject(COUNT, Collections.emptyMap(), Integer.class);
        }
        return 0;
    }

    public List<Product> select(String category, int page){
        if ( category.equals("all") ){
            Map<String, Integer> params = new HashMap<>();
            params.put("start", 0 + (page - 1) * 4);
            params.put("length", 4);
            params.put("category", 0);

            return this.jdbc.query(SELECT_ALL.replace("{{=}}", "<>"), params, rowMapper);
        }
        return null;
    }
}
