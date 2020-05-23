package lec.spring.jdbc.dao;

import lec.spring.jdbc.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static lec.spring.jdbc.dao.RoleSql.*;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    private SimpleJdbcInsert jdbcInsert;

    public RoleDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("role");
    }

    public List<Role> selectAll () {
        return jdbc.query(SELECT_ALL, Collections.EMPTY_MAP, rowMapper);
    }

    public int insertOne (Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbcInsert.execute(params);
    }

    public int updateOne (Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbc.update(UPDATE_ONE, params);
    }
}
