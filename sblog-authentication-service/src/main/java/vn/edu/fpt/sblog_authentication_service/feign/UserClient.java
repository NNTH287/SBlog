package vn.edu.fpt.sblog_authentication_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.fpt.sblog_authentication_service.dto.UserCredential;

@FeignClient(name = "sblog-user-service")
public interface UserClient {

    @GetMapping("/api/users/credential-of/{username}")
    UserCredential getUserCredential(@PathVariable String username);
}
