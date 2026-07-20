package dev.vignesh.ratelimiter.repository;

import dev.vignesh.ratelimiter.models.ApiClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiClientRepository extends JpaRepository<ApiClient,Long>
{

}
