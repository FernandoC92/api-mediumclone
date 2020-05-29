package com.apimc.mediumcloneapi.services;

import java.util.Optional;

import com.apimc.mediumcloneapi.model.entities.Storie;
import com.apimc.mediumcloneapi.model.repositories.StorieRepository;

import org.springframework.stereotype.Service;

@Service
public class StorieService {
    
     private final StorieRepository storieRepository;
     
     public StorieService(StorieRepository storieRepository) {
          this.storieRepository = storieRepository;   
     }
     
     public Storie saveStorie(Storie storie) {
          storieRepository.save(storie);
          return storie;
     }

     public Storie findById(Long id) {
          Optional<Storie> teste = storieRepository.findById(id);
          return !teste.isPresent() ? null : teste.get();
     }

     

}