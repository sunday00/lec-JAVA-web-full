package lec.sunday00.reservation.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Comment {
    private Long id;
    private Long product_id;
    private Long reservation_info_id;
    private Long score;
    private String comment;
    private String user_name;
    private String image;
    private LocalDateTime create_date;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", reservation_info_id=" + reservation_info_id +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", user_name='" + user_name + '\'' +
                ", image='" + image + '\'' +
                ", create_date=" + create_date +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getReservation_info_id() {
        return reservation_info_id;
    }

    public void setReservation_info_id(Long reservation_info_id) {
        this.reservation_info_id = reservation_info_id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }
}
