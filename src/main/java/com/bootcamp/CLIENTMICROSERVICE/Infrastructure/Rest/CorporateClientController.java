package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Rest;

import com.bootcamp.CLIENTMICROSERVICE.Application.CorporateClientOperations;
import com.bootcamp.CLIENTMICROSERVICE.Domain.CorporateClient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/CorporateClient")
@RequiredArgsConstructor
public class CorporateClientController {
    private final CorporateClientOperations corporateClientOperations;
    
    @GetMapping("/getAll")
public Flux<CorporateClient> getAll(){
    return corporateClientOperations.queryAll();
}
@GetMapping("/getByRuc/{ruc}")
public Mono<CorporateClient> getByDni(@PathVariable String ruc){
    return corporateClientOperations.findByRuc(ruc);
}
@PostMapping("/Create")
public Mono<CorporateClient> post(@RequestBody CorporateClient personalClient){
    return corporateClientOperations.create(personalClient) ;
}
@PutMapping("/Update/{ruc}")
public Mono<CorporateClient> put(@PathVariable String ruc,@RequestBody CorporateClient personalClient){
    return corporateClientOperations.update(ruc, personalClient);
}
@DeleteMapping("/Delete/{ruc}")
public void delete(@PathVariable String ruc){
    corporateClientOperations.deleteByRuc(ruc);
}
}
