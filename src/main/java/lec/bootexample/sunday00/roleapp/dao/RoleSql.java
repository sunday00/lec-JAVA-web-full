package lec.bootexample.sunday00.roleapp.dao;

public class RoleSql {
    public static final String SELECT_ALL = "SELECT role_id, description FROM role ORDER BY role_id LIMIT :start , :limit";
}
