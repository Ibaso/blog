package uz.ibaso.blog.mappers;

import org.apache.ibatis.annotations.Mapper;
import uz.ibaso.blog.db.dto.LoginPasswordDto;
import uz.ibaso.blog.db.dto.UsernameTokenDto;
import uz.ibaso.blog.db.entity.UserEntity;

@Mapper
public interface AuthMapper {

    UserEntity findUser(LoginPasswordDto loginPasswordDto);
    UserEntity findUserByToken(String token);
    void setToken(UsernameTokenDto usernameTokenDto);



}
