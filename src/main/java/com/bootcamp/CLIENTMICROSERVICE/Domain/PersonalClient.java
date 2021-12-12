package com.bootcamp.CLIENTMICROSERVICE.Domain;
import lombok.Data;
@Data
public class PersonalClient extends Client{
   private String dni;
   private String personalEmail;
   private String personalPhone; 
   private String personalAddress;
   
  
   
   
}
