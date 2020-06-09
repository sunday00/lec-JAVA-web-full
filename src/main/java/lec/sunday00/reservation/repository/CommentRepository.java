package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Comment;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lec.sunday00.reservation.repository.CommentSql.*;

@Repository
public class CommentRepository extends BaseRepository{
    public CommentRepository(DataSource dataSource, Comment object) {
        super(dataSource, object, "reservation_user_comment");
    }

    public Map score (Long id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("product_id", id.intValue());

        return this.jdbc.queryForMap(SELECT_COUNT, params );
    }

    public List<Comment> selectAll (Long id, int page) {
        Map<String, Integer> params = new HashMap<>();
        params.put("product_id", id.intValue());
        params.put("start", (page - 1) * 10);
        params.put("limit", 10);
        return this.jdbc.query(SELECT_ALL, params, this.rowMapper);
    }

    public List<Comment> select3 (Long id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("product_id", id.intValue());
        return this.jdbc.query(SELECT_3, params, this.rowMapper);
    }
}
