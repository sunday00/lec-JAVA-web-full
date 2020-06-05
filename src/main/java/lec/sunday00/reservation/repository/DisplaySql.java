package lec.sunday00.reservation.repository;

public class DisplaySql {
    public static final String SELECT_ALL = "SELECT d.id as id," +
            " p.description as title, " +
            " p.content as description, " +
            " p.id as product_id, " +
            " d.place_name as address, " +
            " d.opening_hours as openTime, " +
            " f.save_file_name as thumbnail " +

            " FROM display_info d " +

            " LEFT JOIN product p " +
            " ON d.product_id = p.id " +
            " LEFT JOIN product_image pi " +
            " ON p.id = pi.product_id " +
            " LEFT JOIN file_info f " +
            " ON pi.file_id = f.id " +

            " WHERE pi.type = 'th' " +
            " AND p.category_id {{=}} :category " +
            " ORDER BY d.id DESC " +
            " LIMIT :start, :length";

    public static final String SELECT_ONE = "SELECT d.id as id," +
            " p.description as title," +
            " p.content as description," +
            " p.id as product_id," +
            " d.place_name as address," +
            " d.opening_hours as openTime" +

            " FROM display_info d" +

            " LEFT JOIN product p" +
            " ON d.product_id = p.id" +

            " WHERE d.id = :id";

    public static final String COUNT = "select count(*) from display_info d left join product p on d.product_id = p.id";
}
