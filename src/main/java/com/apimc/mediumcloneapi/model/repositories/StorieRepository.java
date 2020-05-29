package com.apimc.mediumcloneapi.model.repositories;

import com.apimc.mediumcloneapi.model.entities.Storie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorieRepository extends JpaRepository<Storie, Long> {
    
    
    
}