package uz.ibaso.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ibaso.blog.db.dto.OutPostDto;
import uz.ibaso.blog.db.dto.PostDto;
import uz.ibaso.blog.services.PostService;
import uz.ibaso.blog.utils.consts.ConstUri;

import java.util.List;

@RestController
@RequestMapping(ConstUri.POST)
public class PostController {
    @Autowired
    PostService service;

    @GetMapping
    public OutPostDto getPostById(@RequestParam Long id) {
        return service.getPostById(id);
    }
    @GetMapping(path="/posts")
    public  List<OutPostDto> getPostsByUsername(@RequestParam String username, @RequestParam String all) {
        return service.getPostsByUsername(username, all);
    }
    @GetMapping(path = "/comments")
    public List<OutPostDto> getComments(@RequestParam Long parent_id) {
        return service.getComments(parent_id);
    }

    @PostMapping("/save")
    public void savePost(@RequestBody PostDto postDto) {
        service.savePost(postDto);
    }

    @DeleteMapping
    public void deletePost(@RequestParam Long id, Long user_id) {
        service.deletePost(id, user_id);
    }

}
