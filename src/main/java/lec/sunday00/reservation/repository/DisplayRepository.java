package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Display;
import lec.sunday00.reservation.model.ImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lec.sunday00.reservation.repository.DisplaySql.*;

@Repository
public class DisplayRepository extends BaseRepository{

    @Autowired
    DisplayImageRepository displayImageRepository;

    public DisplayRepository(DataSource dataSource, Display object) {
        super(dataSource, object, "display_info");
    }

    public int selectCount(String category){
        if ( category.equals("all") ){
            return this.jdbc.queryForObject(COUNT, Collections.emptyMap(), Integer.class);
        } else {
            return this.jdbc.queryForObject(COUNT + " WHERE p.category_id="+category, Collections.emptyMap(), Integer.class);
        }
    }

    public List<Display> select(String category, int page){
        if ( category.equals("all") ){
            Map<String, Integer> params = new HashMap<>();
            params.put("start", 0 + (page - 1) * 4);
            params.put("length", 4);
            params.put("category", 0);

            return this.jdbc.query(SELECT_ALL.replace("{{=}}", "<>"), params, rowMapper);
        } else {
            Map<String, Integer> params = new HashMap<>();
            params.put("start", 0 + (page - 1) * 4);
            params.put("length", 4);
            params.put("category", Integer.parseInt(category));

            return this.jdbc.query(SELECT_ALL.replace("{{=}}", "="), params, rowMapper);
        }
    }

    public Display selectOne (int id) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);

        Display display = (Display) this.jdbc.queryForObject(SELECT_ONE, params, rowMapper);

        List <ImageFile> imageFiles = displayImageRepository.select(id, display.getProduct_id().intValue());
        display.setImages(imageFiles);

        return display;
    }
}
