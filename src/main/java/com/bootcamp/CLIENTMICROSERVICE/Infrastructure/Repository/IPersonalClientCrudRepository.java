package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Repository;

import com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Model.Dao.PersonalClientDao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IPersonalClientCrudRepository extends ReactiveCrudRepository<PersonalClientDao,String> {
    
}
