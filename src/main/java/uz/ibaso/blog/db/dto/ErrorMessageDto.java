package uz.ibaso.blog.db.dto;

import com.google.gson.JsonObject;

import java.io.Serializable;

public class ErrorMessageDto implements Serializable {
    private Integer code;
    private String message;

    public ErrorMessageDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toJson() {
        JsonObject job = new JsonObject();
        job.addProperty("code", this.code);
        job.addProperty("message", this.message);
        return job.toString();
    }
}
