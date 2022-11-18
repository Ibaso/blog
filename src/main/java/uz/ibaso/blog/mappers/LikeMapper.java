package uz.ibaso.blog.mappers;

import org.apache.ibatis.annotations.Mapper;
import uz.ibaso.blog.db.dto.LikeDto;

@Mapper
public interface LikeMapper {
    void insertLike(LikeDto likeDto);
    void deleteLike(Long id, Long user_id);
    void updateLikeCount(Long post_id, Integer increment);
    LikeDto selectLike(Long id, Long user_id);
}
