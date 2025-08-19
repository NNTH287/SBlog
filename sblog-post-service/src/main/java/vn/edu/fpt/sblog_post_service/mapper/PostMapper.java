package vn.edu.fpt.sblog_post_service.mapper;

import org.springframework.stereotype.Component;
import vn.edu.fpt.sblog_post_service.dto.PostItem;
import vn.edu.fpt.sblog_post_service.entity.Post;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper {
    public PostItem postToPostItem(Post post) {
        return new PostItem(post.getTitle(), post.getContent().substring(0, Math.min(post.getContent().length(), 100)));
    }

    public List<PostItem> postsToPostItems(List<Post> posts) {
        List<PostItem> postItems = new ArrayList<>();
        for (Post post : posts) {
            postItems.add(postToPostItem(post));
        }

        return postItems;
    }
}
