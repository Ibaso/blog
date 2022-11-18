package uz.ibaso.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ibaso.blog.db.dto.LikeDto;
import uz.ibaso.blog.mappers.LikeMapper;

@Service
public class LikeService {
    @Autowired
    LikeMapper mapper;

    public void insertLike(LikeDto likeDto){
        if(mapper.selectLike(likeDto.getPost_id(), likeDto.getLiked_user_id()) != null){
            return;
        }
        mapper.insertLike(likeDto);
        mapper.updateLikeCount(likeDto.getPost_id(),1);
    }
    public void deleteLike(Long id, Long user_id){
        mapper.deleteLike(id, user_id);
        mapper.updateLikeCount(id,-1);
    }

}
