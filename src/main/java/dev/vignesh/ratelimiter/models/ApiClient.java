package dev.vignesh.ratelimiter.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "api_clients")
public class ApiClient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String apiKey;
    @Column(nullable = false)
    private Integer limitPerMinute;
    @Column(nullable = false)
    private String algorithm;
    @Column(nullable = false)
    private Boolean enabled;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
