package com.bootcamp.CLIENTMICROSERVICE.Domain;



import lombok.Data;

@Data

public class CorporateClient extends Client{
  private String ruc; 
  private String companyName;
private String officialAdress;
private String corporateEmail;
private String corporatePhone;

}
