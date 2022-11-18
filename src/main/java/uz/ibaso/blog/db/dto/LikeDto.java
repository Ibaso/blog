package uz.ibaso.blog.db.dto;

public class LikeDto {
    private Long liked_user_id;
    private Long post_id;

    public Long getLiked_user_id() {
        return liked_user_id;
    }

    public void setLiked_user_id(Long liked_user_id) {
        this.liked_user_id = liked_user_id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }
}
