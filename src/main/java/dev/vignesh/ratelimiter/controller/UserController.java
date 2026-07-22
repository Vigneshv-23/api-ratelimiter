package dev.vignesh.ratelimiter.controller;

import dev.vignesh.ratelimiter.models.User;
import dev.vignesh.ratelimiter.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<Page<User>> getUserPager(@RequestParam int page,@RequestParam int size)
    {
        return ResponseEntity.ok(userService.getAllUserPager(page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @Valid @RequestBody User user)
    {
        return ResponseEntity.ok(userService.updateUserById(id,user));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
