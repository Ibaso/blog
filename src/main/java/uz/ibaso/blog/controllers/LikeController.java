package uz.ibaso.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ibaso.blog.db.dto.LikeDto;
import uz.ibaso.blog.services.LikeService;
import uz.ibaso.blog.utils.consts.ConstUri;

@RestController
@RequestMapping(ConstUri.LIKE)
public class LikeController {
    @Autowired
    LikeService service;

    @PostMapping
    public void insertLike(@RequestBody LikeDto dto) {
        service.insertLike(dto);
    }

    @DeleteMapping
    public void deleteLike(@RequestParam Long post_id, Long user_id) {
        service.deleteLike(post_id, user_id);
    }


}
