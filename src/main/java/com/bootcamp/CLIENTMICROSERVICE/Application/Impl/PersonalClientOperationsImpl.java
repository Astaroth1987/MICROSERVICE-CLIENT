package com.bootcamp.CLIENTMICROSERVICE.Application.Impl;

import com.bootcamp.CLIENTMICROSERVICE.Application.PersonalClientOperations;
import com.bootcamp.CLIENTMICROSERVICE.Application.Model.PersonalClientRepository;
import com.bootcamp.CLIENTMICROSERVICE.Domain.PersonalClient;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor

public class PersonalClientOperationsImpl implements PersonalClientOperations {

private final PersonalClientRepository repository;

    @Override
    public Flux<PersonalClient> queryAll() {
        
        return repository.getAll();
    }

    @Override
    public Mono<PersonalClient> findByDni(String dni) {
        return repository.getByDni(dni);
    }

    @Override
    public Mono<PersonalClient> create(PersonalClient personalClient) {
        
        return repository.save(personalClient);
    }

    @Override
    public Mono<PersonalClient> update(String dni, PersonalClient personalClient) {
        return repository.update(dni, personalClient);
    }

    @Override
    public void deleteByDni(String dni) {
        repository.deleteByDni(dni);
        
    }

    @Override
    public void publicPersonalClient(PersonalClient personalClient) {
        // TODO Auto-generated method stub
        
    }
    
}
