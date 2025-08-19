package vn.edu.fpt.sblog_post_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.fpt.sblog_post_service.dto.PostItem;
import vn.edu.fpt.sblog_post_service.entity.Post;
import vn.edu.fpt.sblog_post_service.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/users/{userId}")
    public List<PostItem> getPostsOfUser(@PathVariable int userId) {
        return postService.getPostsOfUser(userId);
    }
}
