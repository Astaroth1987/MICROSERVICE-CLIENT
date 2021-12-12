package com.bootcamp.CLIENTMICROSERVICE.Application.Impl;

import com.bootcamp.CLIENTMICROSERVICE.Application.CorporateClientOperations;
import com.bootcamp.CLIENTMICROSERVICE.Application.Model.CorporateClientRepository;
import com.bootcamp.CLIENTMICROSERVICE.Domain.CorporateClient;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class CorporateClientOperationsImpl implements CorporateClientOperations {
    private final CorporateClientRepository repository;

    @Override
    public Flux<CorporateClient> queryAll() {
       
        return repository.getAll();
    }

    @Override
    public Mono<CorporateClient> findByRuc(String ruc) {
       
        return repository.getByRuc(ruc);
    }

    @Override
    public Mono<CorporateClient> create(CorporateClient corporateClient) {
    
        return repository.save(corporateClient);
    }

    @Override
    public Mono<CorporateClient> update(String ruc, CorporateClient corporateClient) {
    
        return repository.update(ruc, corporateClient);
    }

    @Override
    public void deleteByRuc(String ruc) {
        repository.deleteByRuc(ruc);
        
    }

    @Override
    public void publicCorporateClient(CorporateClient corporateClient) {
        
    }

    
}
