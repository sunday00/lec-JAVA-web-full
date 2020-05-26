package lec.spring.layered.dao;

import lec.spring.layered.dto.Log;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;

@Repository
public class LogDao {
    public static final String SELECT_COUNT = "SELECT count(*) FROM log";
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    public LogDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("log").usingGeneratedKeyColumns("id");
    }

    public Long insert(Log log){
        SqlParameterSource param = new BeanPropertySqlParameterSource(log);
        return insertAction.executeAndReturnKey(param).longValue();
    }

    public int selectCount() {
        return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
    }
}
