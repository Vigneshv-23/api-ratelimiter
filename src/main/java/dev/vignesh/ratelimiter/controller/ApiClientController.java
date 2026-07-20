package dev.vignesh.ratelimiter.controller;

import dev.vignesh.ratelimiter.models.ApiClient;
import dev.vignesh.ratelimiter.service.ApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    ResponseEntity<ApiClient> createClient(@RequestBody ApiClient apiClient)
    {
        return ResponseEntity.ok(apiClientService.createApiClient(apiClient));
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiClient> getApiClientById(@PathVariable Long id)
    {
        return ResponseEntity.ok(apiClientService.getApiClientById(id));
    }


    @PutMapping("/{id}")
    ResponseEntity<ApiClient> updateApiClientById(@PathVariable Long id, @RequestBody ApiClient apiClient)
    {
        return  ResponseEntity.ok(apiClientService.updateApiClientById(id, apiClient));
    }

    @GetMapping
    ResponseEntity<List<ApiClient>> getAllClients()
    {
        return ResponseEntity.ok(apiClientService.getAllClients());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id)
    {
        apiClientService.deleteClientById(id);
       return ResponseEntity.noContent().build();
    }


}
