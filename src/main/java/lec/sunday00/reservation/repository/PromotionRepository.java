package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Promotion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

import static lec.sunday00.reservation.repository.PromotionSql.*;

@Repository
public class PromotionRepository {

    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

    public PromotionRepository (DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("promotion").usingGeneratedKeyColumns("id");
    }

    public List<Promotion> selectAll (){
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), this.rowMapper);
    }
}
