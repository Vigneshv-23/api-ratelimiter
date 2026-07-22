package dev.vignesh.ratelimiter.controller;

import dev.vignesh.ratelimiter.models.ApiClient;
import dev.vignesh.ratelimiter.service.ApiClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ApiClientController
{
    @Autowired
    private ApiClientService apiClientService;

    @PostMapping
    ResponseEntity<ApiClient> createClient(@Valid @RequestBody ApiClient apiClient)
    {
        return ResponseEntity.ok(apiClientService.createApiClient(apiClient));
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiClient> getApiClientById(@PathVariable Long id)
    {
        return ResponseEntity.ok(apiClientService.getApiClientById(id));
    }
    @GetMapping
    ResponseEntity<Page<ApiClient>> getApiClientPage(@RequestParam int page,@RequestParam int size)
    {
        return ResponseEntity.ok(apiClientService.getAllClientsPager(page, size));
    }

    @PutMapping("/{id}")
    ResponseEntity<ApiClient> updateApiClientById(@PathVariable Long id, @Valid @RequestBody ApiClient apiClient)
    {
        return  ResponseEntity.ok(apiClientService.updateApiClientById(id, apiClient));
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id)
    {
        apiClientService.deleteClientById(id);
       return ResponseEntity.noContent().build();
    }


}
