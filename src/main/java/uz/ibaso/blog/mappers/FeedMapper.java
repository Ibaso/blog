package uz.ibaso.blog.mappers;

import org.apache.ibatis.annotations.Mapper;
import uz.ibaso.blog.db.dto.OutPostDto;
import uz.ibaso.blog.db.entity.TestEntity;

import java.util.List;

@Mapper
public interface FeedMapper {
    List<OutPostDto> selectAll();
}
