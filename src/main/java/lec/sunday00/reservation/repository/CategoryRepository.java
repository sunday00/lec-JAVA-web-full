package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Category;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static lec.sunday00.reservation.repository.CategorySql.*;

@Repository
public class CategoryRepository extends BaseRepository {

    public CategoryRepository(DataSource dataSource, Category category) {
        super(dataSource, category, "category");
    }

    public List<Category> selectAll () {
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), this.rowMapper );
    }
}
