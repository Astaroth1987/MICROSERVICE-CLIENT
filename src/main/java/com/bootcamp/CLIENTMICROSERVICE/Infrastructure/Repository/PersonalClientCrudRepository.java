package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Repository;

import com.bootcamp.CLIENTMICROSERVICE.Application.Model.PersonalClientRepository;
import com.bootcamp.CLIENTMICROSERVICE.Domain.PersonalClient;
import com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Model.Dao.PersonalClientDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonalClientCrudRepository implements PersonalClientRepository {
@Autowired
IPersonalClientCrudRepository repository;

    @Override
    public Mono<PersonalClient> getByDni(String dni) {
        return repository.findById(dni)
        .map(this::mapPersonalClientDaoToPersonalClient);
    }

    @Override
    public Flux<PersonalClient> getAll() {
        return repository.findAll()
        .map(this::mapPersonalClientDaoToPersonalClient);
    }

    @Override
    public Mono<PersonalClient> save(PersonalClient personalClient) {
        return repository.save(mapPersonalClientToPersonalClientDao(personalClient))
        .map(this::mapPersonalClientDaoToPersonalClient);
    }

    @Override
    public Mono<PersonalClient> update(String dni, PersonalClient personalClient) {
        return repository.findById(dni)
        .flatMap( p ->save(mapPersonalClientDaoToPersonalClient(p,personalClient)));
    }

    @Override
    public void deleteByDni(String dni) {
        repository.deleteById(dni).subscribe();
        
    }

    private PersonalClient mapPersonalClientDaoToPersonalClient(PersonalClientDao personalClientDao){
PersonalClient personalClient=new PersonalClient();
personalClient.setDni(personalClientDao.getDni());
personalClient.setNames(personalClientDao.getNames());
personalClient.setSurenames(personalClientDao.getSurenames());
personalClient.setStatus(personalClientDao.getStatus());
personalClient.setPersonalAddress(personalClientDao.getPersonalAddress());
personalClient.setPersonalEmail(personalClientDao.getPersonalEmail());
personalClient.setPersonalPhone(personalClientDao.getPersonalPhone());
return personalClient;

    }
    private PersonalClientDao mapPersonalClientToPersonalClientDao(PersonalClient personalClient){
        PersonalClientDao personalClientDao=new PersonalClientDao();
        personalClientDao.setDni(personalClient.getDni());
        personalClientDao.setNames(personalClient.getNames());
        personalClientDao.setSurenames(personalClient.getSurenames());
        personalClientDao.setStatus(personalClient.getStatus());
        personalClientDao.setPersonalAddress(personalClient.getPersonalAddress());
        personalClientDao.setPersonalEmail(personalClient.getPersonalEmail());
        personalClientDao.setPersonalPhone(personalClient.getPersonalPhone());
        return personalClientDao;
        
            }

            private PersonalClient mapPersonalClientDaoToPersonalClient (PersonalClientDao personalClientDao,  PersonalClient personalClient){
                personalClient.setDni(personalClientDao.getDni());
                return personalClient;
            }

  
    
}
