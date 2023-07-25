package org.example.user.service;

import org.example.user.entity.User;
import org.example.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userJpaRepository;

    public UserService(UserRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public List<User> getAllUsers() {
        return  userJpaRepository.findAll();
    }

    public User getUserById(long id) {
        return userJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("User with id %d was not found.", id))
        );
    }

    public User createUser(User user) {
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userJpaRepository.save(user);
    }
}
