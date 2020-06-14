package lec.bootexample.sunday00.roleapp.dao;

import lec.bootexample.sunday00.roleapp.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static lec.bootexample.sunday00.roleapp.dao.RoleSql.SELECT_ALL;

@Repository
public class RoleRepository {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertOne;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertOne = new SimpleJdbcInsert(dataSource).withTableName("role");
    }

    public List<Role> selectAll () {
        int start = 0;
        int limit = 10;

        HashMap<String, Integer> param = new HashMap<>();
        param.put("start", start);
        param.put("limit", limit);
        return jdbc.query(SELECT_ALL, param, rowMapper);
    }
}
