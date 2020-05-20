package com.apimc.mediumcloneapi.model.repositories;

import com.apimc.mediumcloneapi.model.entities.Topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRespository extends JpaRepository<Topic, Long>{
    
}