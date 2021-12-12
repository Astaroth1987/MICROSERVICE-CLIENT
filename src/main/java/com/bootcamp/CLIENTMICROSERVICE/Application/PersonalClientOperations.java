package com.bootcamp.CLIENTMICROSERVICE.Application;


import com.bootcamp.CLIENTMICROSERVICE.Domain.PersonalClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalClientOperations {
    Flux<PersonalClient> queryAll();
    Mono<PersonalClient> findByDni(String dni);
    Mono<PersonalClient> create(PersonalClient personalClient);
    Mono<PersonalClient> update(String dni, PersonalClient personalClient);
    void deleteByDni(String dni);
    void publicPersonalClient(PersonalClient personalClient);

  

}
