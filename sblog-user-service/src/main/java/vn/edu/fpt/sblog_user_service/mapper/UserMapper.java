package vn.edu.fpt.sblog_user_service.mapper;

import org.springframework.stereotype.Component;
import vn.edu.fpt.sblog_user_service.dto.UserAuthnInformation;
import vn.edu.fpt.sblog_user_service.dto.UserPublicInformation;
import vn.edu.fpt.sblog_user_service.dto.UserRegisterRequest;
import vn.edu.fpt.sblog_user_service.dto.UserUpdateRequest;
import vn.edu.fpt.sblog_user_service.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public User UserRegisterRequestToUser(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setUsername(userRegisterRequest.username());
        user.setFullName(userRegisterRequest.fullName());

        return user;
    }

    public void updateEntity(User user, UserUpdateRequest userUpdateRequest) {
        user.setFullName(userUpdateRequest.fullName());
        user.setHashedPassword(userUpdateRequest.password());
    }

    public UserPublicInformation UserToUserPublicInformation(User user) {
        return new UserPublicInformation(user.getId(), user.getUsername());
    }

    public List<UserPublicInformation> UsersToUserPublicInformation(List<User> users) {
        List<UserPublicInformation> userPublicInformation = new ArrayList<>();

        for (User user : users) {
            userPublicInformation.add(UserToUserPublicInformation(user));
        }

        return userPublicInformation;
    }

    public UserAuthnInformation UserToUserAuthnInformation(User user) {
        return new UserAuthnInformation(user.getUsername(), user.getHashedPassword());
    }
}
