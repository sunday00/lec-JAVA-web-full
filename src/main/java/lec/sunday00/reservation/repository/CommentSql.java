package lec.sunday00.reservation.repository;

public class CommentSql {
    public static final String SELECT_3 = "SELECT c.id, c.product_id, c.reservation_info_id, c.score, c.comment, f.save_file_name as image, r.reservation_name as user_name, c.create_date FROM reservation_user_comment c " +
            " LEFT JOIN reservation_user_comment_image ci " +
            " ON ci.reservation_user_comment_id = c.id " +
            " LEFT JOIN reservation_info r " +
            " ON r.id = c.reservation_info_id " +
            " LEFT JOIN file_info f " +
            " ON f.id = ci.file_id" +
            " WHERE c.product_id = :product_id " +
            " ORDER BY c.id DESC " +
            " LIMIT 3";

    public static final String SELECT_COUNT = "SELECT COUNT(*) as cnt, AVG(score) as avg FROM reservation_user_comment " +
            " WHERE product_id = :product_id ";
}
