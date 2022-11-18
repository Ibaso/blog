package uz.ibaso.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ibaso.blog.db.dto.OutPostDto;
import uz.ibaso.blog.db.entity.TestEntity;
import uz.ibaso.blog.services.FeedService;
import uz.ibaso.blog.utils.consts.ConstUri;

import java.util.List;

@RestController
@RequestMapping(ConstUri.FEED)
public class FeedController {
    @Autowired
    private FeedService service;

    @GetMapping
    public List<OutPostDto> getPosts(){
       return service.getPosts();
    }
}
