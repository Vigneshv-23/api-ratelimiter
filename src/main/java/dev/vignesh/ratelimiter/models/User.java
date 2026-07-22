package dev.vignesh.ratelimiter.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "name cannot be empty")
    private String name;
    @Column(nullable = false)
    @Email
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @Column(nullable = false)
    @Size(min = 8,max =100 ,message = "passwords must be atleast 8 characters")
    @NotBlank(message = "Enter a valid Password")
    private String password;
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist()
    {
        this.createdAt = LocalDateTime.now();
    }

}
