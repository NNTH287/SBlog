package vn.edu.fpt.sblog_post_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.fpt.sblog_post_service.dto.PostItem;
import vn.edu.fpt.sblog_post_service.entity.Post;
import vn.edu.fpt.sblog_post_service.mapper.PostMapper;
import vn.edu.fpt.sblog_post_service.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public List<PostItem> getPostsOfUser(int userId) {
        return postMapper.postsToPostItems(postRepository.findByUserId(userId));
    }
}
