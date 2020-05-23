package lec.spring.jdbc.dao;

import lec.spring.jdbc.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static lec.spring.jdbc.dao.RoleSql.*;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Role> selectAll () {
        return jdbc.query(SELECT_ALL, Collections.EMPTY_MAP, rowMapper);
    }
}
