package vn.edu.fpt.sblog_user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.fpt.sblog_user_service.common.ApiResponse;
import vn.edu.fpt.sblog_user_service.dto.UserPublicInformation;
import vn.edu.fpt.sblog_user_service.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserPublicInformation>>> getAllUsers() {
        List<UserPublicInformation> userPublicInformationList = userService.getAllUsers();
        ApiResponse<List<UserPublicInformation>> apiResponse = new ApiResponse<>(
                200,"Retrieved list of all users", userPublicInformationList
        );

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserPublicInformation>> getUserById(@PathVariable int id) {
        UserPublicInformation userPublicInformation = userService.getUserById(id);
        ApiResponse<UserPublicInformation> apiResponse = new ApiResponse<>(
                200,"User info retrieved", userPublicInformation
        );

        return ResponseEntity.ok(apiResponse);
    }
}
