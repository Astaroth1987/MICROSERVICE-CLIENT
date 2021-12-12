package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Model.Dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("corporateClients")

@Data
public class CorporateClientDao {
    
@Id
private String ruc;
private String names;
private String surenames;
private String status;
private String companyName;
private String officialAdress;
private String corporateEmail;
private String corporatePhone;
}
