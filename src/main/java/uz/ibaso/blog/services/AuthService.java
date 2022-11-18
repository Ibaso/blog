package uz.ibaso.blog.services;

import org.springframework.stereotype.Service;
import uz.ibaso.blog.db.dto.LoginPasswordDto;
import uz.ibaso.blog.db.entity.UserEntity;
import uz.ibaso.blog.exceptions.UserNotFoundException;
import uz.ibaso.blog.mappers.AuthMapper;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthService {
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
    final AuthMapper mapper;

    public AuthService(AuthMapper mapper) {
        this.mapper = mapper;
    }

    public UserEntity getUser(LoginPasswordDto auth) {
        UserEntity user = mapper.findUser(auth);
        if (user == null){
            throw  new UserNotFoundException("Login yoki parol xato");
        }
        String token = generateNewToken();
        user.setToken(token);
        return user;
    }


    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
