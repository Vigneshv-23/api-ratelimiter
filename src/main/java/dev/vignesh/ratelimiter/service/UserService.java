package dev.vignesh.ratelimiter.service;

import dev.vignesh.ratelimiter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.vignesh.ratelimiter.models.User;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user)
    {
        return userRepository.save(user);
    }
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }
    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUserById(Long id, User user)
    {
        User existinguser = userRepository.findById(id).orElseThrow();

        existinguser.setName(user.getName());
        existinguser.setEmail(user.getEmail());
        existinguser.setPassword(user.getPassword());

        return userRepository.save(existinguser);
    }

    public void deleteById(Long id)
    {
         userRepository.deleteById(id);

    }
}
