package com.apimc.mediumcloneapi.model.repositories;

import com.apimc.mediumcloneapi.model.entities.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    
}