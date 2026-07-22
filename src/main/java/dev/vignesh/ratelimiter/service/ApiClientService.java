package dev.vignesh.ratelimiter.service;

import dev.vignesh.ratelimiter.models.ApiClient;
import dev.vignesh.ratelimiter.repository.ApiClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Service
public class ApiClientService
{
    @Autowired
    private ApiClientRepository apiClientRepository;
    public ApiClient createApiClient(ApiClient apiClient)
    {
        return apiClientRepository.save(apiClient);
    }
    public ApiClient getApiClientById(Long id)
    {
        return apiClientRepository.findById(id).orElseThrow();
    }
    public ApiClient updateApiClientById(Long id, ApiClient apiClient)
    {
        ApiClient existingClient = apiClientRepository.findById(id).orElseThrow();
        existingClient.setName(apiClient.getName());
        existingClient.setAlgorithm(apiClient.getAlgorithm());
        existingClient.setEnabled(apiClient.getEnabled());
        existingClient.setLimitPerMinute(apiClient.getLimitPerMinute());

        return apiClientRepository.save(existingClient);
    }

    public List<ApiClient> getAllClients()
    {
        return apiClientRepository.findAll();
    }
    public Page <ApiClient> getAllClientsPager(int page,int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return apiClientRepository.findAll(pageable);
    }

    public void deleteClientById(Long id)
    {
        apiClientRepository.deleteById(id);
    }



}
