package uz.ibaso.blog.exceptions;

import uz.ibaso.blog.db.entity.UserEntity;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(){

    }
}
