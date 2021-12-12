package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Repository;

import com.bootcamp.CLIENTMICROSERVICE.Application.Model.CorporateClientRepository;
import com.bootcamp.CLIENTMICROSERVICE.Domain.CorporateClient;
import com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Model.Dao.CorporateClientDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CorporateClientCrudRepository implements CorporateClientRepository {
@Autowired
ICorporateClientCrudRepository repository;
    @Override
    public Mono<CorporateClient> getByRuc(String ruc) {
        return repository.findById(ruc)
        .map(this::mapCorporateClientDaoToCorporateClient);
    }

    @Override
    public Flux<CorporateClient> getAll() {
        
        return repository.findAll().map(this::mapCorporateClientDaoToCorporateClient) ;
    }

    @Override
    public Mono<CorporateClient> save(CorporateClient corporateClient) {
        
        return repository.save(mapCorporateClientToCorporateClientDao(corporateClient))
        .map(this::mapCorporateClientDaoToCorporateClient);
    }

    @Override
    public Mono<CorporateClient> update(String ruc, CorporateClient corporateClient) {
        return repository.findById(ruc)
        .flatMap( p ->save(mapCorporateClientDaoToCorporateClient(p,corporateClient)));
    }

    @Override
    public void deleteByRuc(String ruc) {
        repository.deleteById(ruc).subscribe();
        
    }
    
    private CorporateClient mapCorporateClientDaoToCorporateClient(CorporateClientDao corporateClientDao){
        CorporateClient corporateClient=new CorporateClient();
       corporateClient.setRuc(corporateClientDao.getRuc());
       corporateClient.setNames(corporateClientDao.getNames());
       corporateClient.setSurenames(corporateClientDao.getSurenames());
       corporateClient.setStatus(corporateClientDao.getStatus());
       corporateClient.setCompanyName(corporateClientDao.getCompanyName());
       corporateClient.setOfficialAdress(corporateClientDao.getOfficialAdress());
       corporateClient.setCorporateEmail(corporateClientDao.getCorporateEmail());
       corporateClient.setCorporatePhone(corporateClientDao.getCorporatePhone());

        return corporateClient;
        
            }
            private CorporateClientDao mapCorporateClientToCorporateClientDao(CorporateClient corporateClient){
                CorporateClientDao corporateClientDao=new CorporateClientDao();
                corporateClientDao.setRuc(corporateClient.getRuc());
                corporateClientDao.setNames(corporateClient.getNames());
                corporateClientDao.setSurenames(corporateClient.getSurenames());
                corporateClientDao.setStatus(corporateClient.getStatus());
                corporateClientDao.setCompanyName(corporateClient.getCompanyName());
                corporateClientDao.setOfficialAdress(corporateClient.getOfficialAdress());
                corporateClientDao.setCorporateEmail(corporateClient.getCorporateEmail());
                corporateClientDao.setCorporatePhone(corporateClient.getCorporatePhone());
                return corporateClientDao;
                
                    }

                    private CorporateClient mapCorporateClientDaoToCorporateClient (CorporateClientDao corporateClientDao,  CorporateClient corporateClient){
                        corporateClient.setRuc(corporateClientDao.getRuc());
                        return corporateClient;
                    }
}
