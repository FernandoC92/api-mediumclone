package com.apimc.mediumcloneapi.controllers.dto;

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
    private String datePoster;
    // private List<Topic> topicAssociated;
    // private List<Tag> tagsAssociated;
 
}