package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Repository;

import com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Model.Dao.CorporateClientDao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ICorporateClientCrudRepository extends ReactiveCrudRepository<CorporateClientDao,String>   {
    
}
