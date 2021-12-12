package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Rest;

import com.bootcamp.CLIENTMICROSERVICE.Application.PersonalClientOperations;
import com.bootcamp.CLIENTMICROSERVICE.Domain.PersonalClient;

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
@RequestMapping("/PersonalClient")
@RequiredArgsConstructor
public class PersonalClientController {
private  final PersonalClientOperations personalClientOperations;

@GetMapping("/getAll")
public Flux<PersonalClient> getAll(){
    return personalClientOperations.queryAll();
}
@GetMapping("/getByDni/{dni}")
public Mono<PersonalClient> getByDni(@PathVariable String dni){
    return personalClientOperations.findByDni(dni);
}
@PostMapping("/Create")
public Mono<PersonalClient> post(@RequestBody PersonalClient personalClient){
    return personalClientOperations.create(personalClient) ;
}
@PutMapping("/Update/{dni}")
public Mono<PersonalClient> put(@PathVariable String dni,@RequestBody PersonalClient personalClient){
    return personalClientOperations.update(dni, personalClient);
}
@DeleteMapping("/Delete/{dni}")
public void delete(@PathVariable String dni){
    personalClientOperations.deleteByDni(dni);
}






}
