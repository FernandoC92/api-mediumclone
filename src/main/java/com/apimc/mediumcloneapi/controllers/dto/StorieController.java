package com.apimc.mediumcloneapi.controllers.dto;

import com.apimc.mediumcloneapi.model.entities.Storie;
import com.apimc.mediumcloneapi.services.StorieService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/storie")
@NoArgsConstructor
public class StorieController {
    
    private StorieService service;
    private ModelMapper modelMapper; 

    public StorieController(StorieService service, ModelMapper mapper) {
        this.service = service;
        this.modelMapper = mapper;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public StorieDto create(@RequestBody StorieDto dto) {
        
        Storie entity = modelMapper.map(dto, Storie.class);
        entity = service.save(entity);

        return modelMapper.map(dto, StorieDto.class);

    }

}