package vn.edu.fpt.sblog_user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.fpt.sblog_user_service.dto.UserAuthnInformation;
import vn.edu.fpt.sblog_user_service.dto.UserPublicInformation;
import vn.edu.fpt.sblog_user_service.entity.User;
import vn.edu.fpt.sblog_user_service.mapper.UserMapper;
import vn.edu.fpt.sblog_user_service.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper;

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

    public UserAuthnInformation getUserAuthnInformationById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User with id=" + id + " not found"));

        return userMapper.UserToUserAuthnInformation(user);
    }

    public boolean isExist(String username) {
        return userRepository.existsByUsername(username);
    }

    public UserPublicInformation save(User user) {
        return userMapper.UserToUserPublicInformation(userRepository.save(user));
    }

    public void delete(int id) {
        if(userRepository.existsById(id)) {
            throw new RuntimeException("User with id=" + id + " not found");
        }

        userRepository.deleteById(id);
    }
}
