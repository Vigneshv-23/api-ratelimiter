package dev.vignesh.ratelimiter.models;
import dev.vignesh.ratelimiter.enums.RateLimitAlgorithm;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "api_clients")
public class ApiClient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Client name is required")
    @Size(min = 3,max = 50,message = "Client name must be between 3 and 50 characters")
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String apiKey;
    @Column(nullable = false)
    @NotNull(message = "Rate limit is Required")
    @Positive(message = "limit should be positive")
    @Max(value = 100000,message = "Max limit is 100000")
    private Integer limitPerMinute;
    @Column(nullable = false)
    @NotNull(message = "algorithm is required")
    @Enumerated(EnumType.STRING)
    private RateLimitAlgorithm algorithm;
    @Column(nullable = false)
    @NotNull(message = "Enabled status is required")
    private Boolean enabled;
    @NotNull(message = "User is Required")
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
