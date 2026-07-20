package dev.vignesh.ratelimiter.repository;

import dev.vignesh.ratelimiter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{

}
