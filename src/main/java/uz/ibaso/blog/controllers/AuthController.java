package uz.ibaso.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ibaso.blog.db.dto.LoginPasswordDto;
import uz.ibaso.blog.db.entity.UserEntity;
import uz.ibaso.blog.services.AuthService;
import uz.ibaso.blog.utils.consts.ConstUri;

@RestController
@RequestMapping(ConstUri.AUTH)
public class AuthController {
    @Autowired
    AuthService service;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginPasswordDto auth) {
        UserEntity user = service.getUser(auth);

        if (user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(512).body("Username yoki parol xato");
    }

}
