package vn.edu.fpt.sblog_post_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.fpt.sblog_post_service.dto.AuthorAndPosts;
import vn.edu.fpt.sblog_post_service.dto.AuthorDetails;
import vn.edu.fpt.sblog_post_service.dto.PostItem;
import vn.edu.fpt.sblog_post_service.fegin.UserClient;
import vn.edu.fpt.sblog_post_service.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final UserClient userClient;

    @Autowired
    public PostController(PostService postService, UserClient userClient) {
        this.postService = postService;
        this.userClient = userClient;
    }


    @GetMapping("/users/{userId}")
    public AuthorAndPosts getPostsOfUser(@PathVariable int userId) {
        AuthorDetails authorDetails = userClient.getAuthorDetails(userId);

        if (authorDetails == null) {
            throw new RuntimeException("User not found");
        }

        return new AuthorAndPosts(authorDetails, postService.getPostsOfUser(userId));
    }
}
