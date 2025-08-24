package vn.edu.fpt.sblog_post_service.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.fpt.sblog_post_service.dto.AuthorDetails;

@FeignClient(name = "sblog-user-service")
public interface UserClient {

    @GetMapping("/api/users/{userId}")
    AuthorDetails getAuthorDetails(@PathVariable Integer userId);
}
