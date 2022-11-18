package uz.ibaso.blog.services;

import org.springframework.stereotype.Service;
import uz.ibaso.blog.db.dto.OutPostDto;
import uz.ibaso.blog.db.entity.TestEntity;
import uz.ibaso.blog.mappers.FeedMapper;

import java.util.List;

@Service
public class FeedService {

    final FeedMapper mapper;

    public FeedService(FeedMapper mapper) {
        this.mapper = mapper;
    }


    public List<OutPostDto> getPosts() {
        return mapper.selectAll();
    }


}
