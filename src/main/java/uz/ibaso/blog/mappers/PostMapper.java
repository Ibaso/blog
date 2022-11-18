package uz.ibaso.blog.mappers;

import org.apache.ibatis.annotations.Mapper;
import uz.ibaso.blog.db.dto.OutPostDto;
import uz.ibaso.blog.db.dto.PostDto;

import java.util.List;

@Mapper
public interface PostMapper {
    Integer savePost(PostDto postDto);

    void deletePost(Long id);

    Long getPostAuthor(Long post_id);
    Integer getCommentsCount(Long post_id);
    OutPostDto getPostById(Long id);
    List<OutPostDto> getPostsByUsername(String username, String all);
    List <OutPostDto> getComments(Long id);
    void updateCommentCount(Integer comment_count, Long post_id);
}
