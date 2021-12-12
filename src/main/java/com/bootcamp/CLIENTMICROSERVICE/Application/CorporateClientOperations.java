package com.bootcamp.CLIENTMICROSERVICE.Application;

import com.bootcamp.CLIENTMICROSERVICE.Domain.CorporateClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CorporateClientOperations {
    Flux<CorporateClient> queryAll();
    Mono<CorporateClient> findByRuc(String ruc);
    Mono<CorporateClient> create(CorporateClient corporateClient);
    Mono<CorporateClient> update(String ruc, CorporateClient corporateClient);
    void deleteByRuc(String ruc);
    void publicCorporateClient(CorporateClient corporateClient);
}
