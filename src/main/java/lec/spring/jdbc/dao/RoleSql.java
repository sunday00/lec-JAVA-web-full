package lec.spring.jdbc.dao;

public class RoleSql {
    public static final String SELECT_ALL = "SELECT * FROM role ORDER BY role_id";
    public static final String SELECT_ONE = "SELECT * FROM role WHERE role_id = :id";
    public static final String UPDATE_ONE = "UPDATE ROLE SET description = :description WHERE role_id = :roleId";
    public static final String DELETE_ONE = "DELETE FROM ROLE WHERE role_id = :id";
}
