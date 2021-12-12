package com.bootcamp.CLIENTMICROSERVICE.Application.Model;

import com.bootcamp.CLIENTMICROSERVICE.Domain.PersonalClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalClientRepository {
    Mono<PersonalClient> getByDni(String dni);
    Flux<PersonalClient> getAll();
    Mono<PersonalClient> save(PersonalClient personalClient);
    Mono<PersonalClient> update(String dni, PersonalClient personalClient);
    void deleteByDni(String dni);

}
