package com.bootcamp.CLIENTMICROSERVICE.Infrastructure.Model.Dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;


@Document("personalClients")

@Data
public class PersonalClientDao {
@Id
private String dni;
private String names;
private String surenames;
private String status;
private String personalEmail;
private String personalPhone; 
private String personalAddress;


}