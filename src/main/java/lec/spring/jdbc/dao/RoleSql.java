package lec.spring.jdbc.dao;

public class RoleSql {
    public static final String SELECT_ALL = "SELECT * FROM role ORDER BY role_id";
    public static final String UPDATE_ONE = "UPDATE ROLE SET description = :description WHERE role_id = :roleId";
}
