package uz.ibaso.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ibaso.blog.db.dto.OutPostDto;
import uz.ibaso.blog.db.dto.PostDto;
import uz.ibaso.blog.exceptions.AccessDeniedException;
import uz.ibaso.blog.mappers.PostMapper;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper mapper;

    public OutPostDto getPostById(Long id) {
        return mapper.getPostById(id);
    }
    public List<OutPostDto> getPostsByUsername(String username, String all) {
        return mapper.getPostsByUsername(username, all);
    }

    public List<OutPostDto> getComments(Long parent_id) {
        return mapper.getComments(parent_id);
    }

    public void savePost(PostDto postDto) {
        Integer comment_count;
        mapper.savePost(postDto);
        comment_count = mapper.getCommentsCount(postDto.getParent_id());
        OutPostDto parent = mapper.getPostById(postDto.getParent_id());
        if (parent != null) {
            mapper.updateCommentCount(comment_count, parent.getId());
        }


    }

    public void deletePost(Long id, Long user_id) {
        Long postAuthor = mapper.getPostAuthor(id);
        if (postAuthor == user_id) {
            mapper.deletePost(id);
        } else throw new AccessDeniedException();


    }
}
