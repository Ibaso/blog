package uz.ibaso.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ibaso.blog.db.dto.SignUpDto;
import uz.ibaso.blog.db.dto.UserDto;
import uz.ibaso.blog.mappers.UsersMapper;

@Service
public class UsersService {
    @Autowired
    UsersMapper mapper;

    public UserDto getUserByUserName(String username) {

        return mapper.getUserByUserName(username);
    }
    public void insertUser(SignUpDto signUpDto){
        mapper.insertUser(signUpDto);
    }

}
