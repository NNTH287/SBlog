package vn.edu.fpt.sblog_post_service.dto;

import java.io.Serializable;
import java.util.List;

public record AuthorAndPosts(AuthorDetails authorDetails, List<PostItem> postItems){
}
