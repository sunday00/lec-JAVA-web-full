package lec.sunday00.reservation.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Product {
    private Long id;
    private String title;
    private String address;
    private String description;
    private String thumbnail;
    private List<String> images;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", images=" + images +
                '}';
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
