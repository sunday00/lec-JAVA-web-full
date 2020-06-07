package lec.sunday00.reservation.repository;

public class CommentSql {
    public static final String SELECT_3 = "SELECT * FROM reservation_user_comment " +
            " WHERE product_id = :product_id " +
            " ORDER BY id DESC " +
            " LIMIT 3";

    public static final String SELECT_COUNT = "SELECT COUNT(*) as cnt, AVG(score) as avg FROM reservation_user_comment " +
            " WHERE product_id = :product_id ";
}
