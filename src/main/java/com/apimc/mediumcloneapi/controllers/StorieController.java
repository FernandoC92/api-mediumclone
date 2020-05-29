package com.apimc.mediumcloneapi.controllers;

import com.apimc.mediumcloneapi.controllers.dto.StorieDto;
import com.apimc.mediumcloneapi.model.entities.Storie;
import com.apimc.mediumcloneapi.services.StorieService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/storie")
public class StorieController {
    
    private final StorieService service;
    private final ModelMapper modelMapper;

    public StorieController(StorieService service, ModelMapper mapper) {
        this.service = service;
        this.modelMapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StorieDto create(@RequestBody StorieDto dto) {

        Storie entity = modelMapper.map(dto, Storie.class);
        entity = service.saveStorie(entity);

        return modelMapper.map(dto, StorieDto.class);

    }

    @GetMapping
    public StorieDto findById() {
        
        Storie entity = service.findById(1L);
        StorieDto dto = modelMapper.map(entity, StorieDto.class);
        return dto;

    }

}

/* Controller, Services and Repository */