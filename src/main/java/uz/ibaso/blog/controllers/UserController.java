package uz.ibaso.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ibaso.blog.db.dto.SignUpDto;
import uz.ibaso.blog.db.dto.UserDto;
import uz.ibaso.blog.db.entity.UserEntity;
import uz.ibaso.blog.services.UsersService;
import uz.ibaso.blog.utils.consts.ConstUri;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping(ConstUri.USER)
public class UserController {
    @Autowired
    UsersService service;

    @GetMapping
    public UserDto getUserByUserName(@RequestParam String username,@RequestHeader Map<String, String> headers){
        headers.forEach((key,value)->{
            System.out.println(key + " : " + value);
        });
      return   service.getUserByUserName(username);
    }
    @PostMapping("/signup")
    public UserDto insertUser(@RequestBody SignUpDto signUpDto ){
        service.insertUser(signUpDto);
        return service.getUserByUserName(signUpDto.getUsername());
    }

}
