package com.bootcamp.CLIENTMICROSERVICE.Application.Model;

import com.bootcamp.CLIENTMICROSERVICE.Domain.CorporateClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CorporateClientRepository {
    Mono<CorporateClient> getByRuc(String ruc);
    Flux<CorporateClient> getAll();
    Mono<CorporateClient> save(CorporateClient corporateClient);
    Mono<CorporateClient> update(String ruc, CorporateClient corporateClient);
    void deleteByRuc(String ruc);

}
