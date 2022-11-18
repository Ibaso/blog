package uz.ibaso.blog.mappers;

import org.apache.ibatis.annotations.Mapper;
import uz.ibaso.blog.db.dto.UserDto;

@Mapper
public interface UsersMapper {
     UserDto getUserByUserName(String username);
}
