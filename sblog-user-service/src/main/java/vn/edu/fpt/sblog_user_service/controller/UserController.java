package vn.edu.fpt.sblog_user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.fpt.sblog_user_service.common.ApiResponse;
import vn.edu.fpt.sblog_user_service.dto.UserPublicInformation;
import vn.edu.fpt.sblog_user_service.dto.UserRegisterRequest;
import vn.edu.fpt.sblog_user_service.dto.UserUpdateRequest;
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

    @PostMapping
    public ResponseEntity<ApiResponse<UserPublicInformation>> createUser(
            @RequestBody UserRegisterRequest userRegisterRequest
    ) {
        UserPublicInformation userPublicInformation = userService.save(userRegisterRequest);
        ApiResponse<UserPublicInformation> apiResponse = new ApiResponse<>(
                200,"User created", userPublicInformation
        );

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserPublicInformation>> updateUser(
            @PathVariable int id
        ,@RequestBody UserUpdateRequest userUpdateRequest
    ) {
        UserPublicInformation userPublicInformation = userService.update(id, userUpdateRequest);
        ApiResponse<UserPublicInformation> apiResponse = new ApiResponse<>(
                200,"User updated", userPublicInformation
        );

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }
}
