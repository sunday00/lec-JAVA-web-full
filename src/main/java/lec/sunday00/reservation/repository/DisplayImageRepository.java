package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.ImageFile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lec.sunday00.reservation.repository.DisplayImageSql.SELECT_ONE_IMAGES;

@Repository
public class DisplayImageRepository extends BaseRepository{
    public DisplayImageRepository(DataSource dataSource, ImageFile object) {
        super(dataSource, object, "");
    }

    public List<ImageFile> select (int id, int pid) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        params.put("pid", pid);

        return this.jdbc.query(SELECT_ONE_IMAGES, params, this.rowMapper);
    }
}
