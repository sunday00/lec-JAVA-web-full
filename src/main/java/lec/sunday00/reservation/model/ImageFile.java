package lec.sunday00.reservation.model;

import org.springframework.stereotype.Component;

@Component
public class ImageFile {
    private String type;
    private Long file_id;
    private String save_file_name;

    @Override
    public String toString() {
        return "ImageFile{" +
                "type='" + type + '\'' +
                ", file_id=" + file_id +
                ", src='" + save_file_name + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFile_id() {
        return file_id;
    }

    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

    public String getSave_file_name() {
        return save_file_name;
    }

    public void setSave_file_name(String save_file_name) {
        this.save_file_name = save_file_name;
    }
}
