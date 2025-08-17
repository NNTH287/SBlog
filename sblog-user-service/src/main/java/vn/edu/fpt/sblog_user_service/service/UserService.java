package vn.edu.fpt.sblog_user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.fpt.sblog_user_service.dto.UserCredential;
import vn.edu.fpt.sblog_user_service.dto.UserPublicInformation;
import vn.edu.fpt.sblog_user_service.dto.UserRegisterRequest;
import vn.edu.fpt.sblog_user_service.dto.UserUpdateRequest;
import vn.edu.fpt.sblog_user_service.entity.User;
import vn.edu.fpt.sblog_user_service.mapper.UserMapper;
import vn.edu.fpt.sblog_user_service.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserPublicInformation> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.UsersToUserPublicInformation(users);
    }

    public UserPublicInformation getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User with id=" + id + " not found"));

        return userMapper.UserToUserPublicInformation(user);
    }

    public UserCredential getUserCredentialByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new RuntimeException("User with username=" + username + " not found"));

        return userMapper.UserToUserCredential(user);
    }

    public boolean isExist(String username) {
        return userRepository.existsByUsername(username);
    }

    public UserPublicInformation save(UserRegisterRequest userRegisterRequest) {
        User user = userMapper.UserRegisterRequestToUser(userRegisterRequest);

        return userMapper.UserToUserPublicInformation(userRepository.save(user));
    }

    public UserPublicInformation update(int id, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User with id=" + id + " not found"));

        userMapper.updateEntity(user, userUpdateRequest);

        return userMapper.UserToUserPublicInformation(userRepository.save(user));
    }

    public void delete(int id) {
        if(userRepository.existsById(id)) {
            throw new RuntimeException("User with id=" + id + " not found");
        }

        userRepository.deleteById(id);
    }
}
