package lec.sunday00.reservation.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

public class BaseRepository {
    protected NamedParameterJdbcTemplate jdbc;
    protected SimpleJdbcInsert insertAction;
    protected RowMapper rowMapper;

    public BaseRepository (DataSource dataSource, Object object, String tableName) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName(tableName).usingGeneratedKeyColumns("id");
        this.rowMapper = BeanPropertyRowMapper.newInstance(object.getClass());
    }
}
