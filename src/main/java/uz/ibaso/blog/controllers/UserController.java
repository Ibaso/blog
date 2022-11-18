package uz.ibaso.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.ibaso.blog.db.dto.UserDto;
import uz.ibaso.blog.services.UsersService;
import uz.ibaso.blog.utils.consts.ConstUri;

@RestController
@RequestMapping(ConstUri.USER)
public class UserController {
    @Autowired
    UsersService service;

    @GetMapping
    public UserDto getUserByUserName(@RequestParam String username){
      return   service.getUserByUserName(username);
    }

}
