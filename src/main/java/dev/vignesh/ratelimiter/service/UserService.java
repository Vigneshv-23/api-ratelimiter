package dev.vignesh.ratelimiter.service;

import dev.vignesh.ratelimiter.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.vignesh.ratelimiter.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Service
@Slf4j
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user)
    {
        User savedUser = userRepository.save(user);

        log.info("User created successfully with id: {} and email: {}",

                savedUser.getId(), savedUser.getEmail());

        return savedUser;


    }
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }
    public User getUserById(Long id)
    {
        log.info("Updating user with id: {}", id);
        return userRepository.findById(id).orElseThrow();
    }

    public Page <User> getAllUserPager(int page,int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        log.info("Fetching users - page: {}, size: {}", page, size);
        return userRepository.findAll(pageable);
    }

    public User updateUserById(Long id, User user)
    {
        User existinguser = userRepository.findById(id).orElseThrow();

        existinguser.setName(user.getName());
        existinguser.setEmail(user.getEmail());
        existinguser.setPassword(user.getPassword());
        log.info("Fetching user with id: {}", id);
        return userRepository.save(existinguser);
    }

    public void deleteById(Long id)
    {
         log.warn("Deleting user with id: {}", id);
         userRepository.deleteById(id);

    }
}
