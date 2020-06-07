package lec.sunday00.reservation.repository;

public class PromotionSql {
    public static final String SELECT_ALL = "SELECT p.id as promotion_id, d.id as id, pd.description as title, d.place_name as address, d.opening_hours as description, f.save_file_name as thumbnail" +
            " FROM promotion p " +
            " LEFT JOIN product pd " +
            " ON p.product_id = pd.id " +
            " LEFT JOIN product_image pi " +
            " ON pi.`product_id` = pd.id " +
            " LEFT JOIN display_info d " +
            " ON d.product_id = pd.id " +
            " LEFT JOIN file_info f " +
            " ON pi.`file_id` = f.id " +
            " WHERE pi.type = 'th'";
}
