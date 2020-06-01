package lec.sunday00.reservation.repository;

public class ProductSql {
    public static final String SELECT_ALL = "SELECT p.id as id," +
            " p.description as title," +
            " p.content as description," +
            " d.id as did, " +
            " d.place_name as address," +
            " d.opening_hours as openTime," +
            " f.save_file_name as thumbnail" +

            " FROM product p " +

            " LEFT JOIN product_image pi " +
            " ON p.id = pi.`product_id` " +
            " LEFT JOIN display_info d " +
            " ON p.id = d.product_id" +
            " LEFT JOIN file_info f " +
            " ON pi.`file_id` = f.id " +

            " WHERE pi.type = 'th'" +
            " AND d.id IN (SELECT MAX(id) FROM display_info GROUP BY product_id)" +
            " AND p.category_id {{=}} :category " +
            " ORDER BY p.id DESC" +
            " LIMIT :start, :length";

    public static final String COUNT = "SELECT COUNT(*) FROM product";
}
