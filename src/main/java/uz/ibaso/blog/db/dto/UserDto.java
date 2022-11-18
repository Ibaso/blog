package uz.ibaso.blog.db.dto;

import java.util.Date;

public class UserDto {
    private String screen_name;
    private String username;
    private Date created_date;
    private Integer is_private;


    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Integer getIs_private() {
        return is_private;
    }

    public void setIs_private(Integer is_private) {
        this.is_private = is_private;
    }
}
