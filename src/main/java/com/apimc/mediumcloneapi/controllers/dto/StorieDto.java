package com.apimc.mediumcloneapi.controllers.dto;

import java.util.Date;
import java.util.List;

import com.apimc.mediumcloneapi.model.entities.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorieDto {
    
    private Long id;
    private String title;
    private String subtitle;
    private String imgPoster;
    private String storie;
    private String author;
    private Date datePoster;
    // private List<Tag> tags;
 
}