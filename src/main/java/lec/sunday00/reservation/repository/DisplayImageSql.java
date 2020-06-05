package lec.sunday00.reservation.repository;

public class DisplayImageSql {
    public static final String SELECT_ONE_IMAGES = "SELECT t.*" +
            " FROM " +
            " ( " +
            " SELECT pi.type, pi.file_id, f.save_file_name " +
            "   FROM product_image pi " +
            "   LEFT JOIN file_info f " +
            "   ON pi.file_id=f.id " +
            "   WHERE pi.product_id= :pid " +
            " ) t " +

            " UNION " +

            " ( " +
            " SELECT 'map' as type," +
            "   f.id as file_id," +
            "   f.save_file_name " +
            "   FROM display_info_image di " +
            "   LEFT JOIN file_info f " +
            "   ON di.file_id = f.id " +
            "   WHERE di.id = :id" +
            " ) ";
}
