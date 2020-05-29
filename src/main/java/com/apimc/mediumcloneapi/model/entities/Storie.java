package com.apimc.mediumcloneapi.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Storie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter String title;
    private @Getter @Setter String subtitle;
    private @Getter @Setter String imgPoster;
    private @Getter @Setter String storie;
    private @Getter @Setter String author;
    private @Getter @Setter String datePoster;

    // @OneToMany(targetEntity = Topic.class)
    // private @Getter @Setter List<Topic> topicAssociated;

    // @ManyToMany(targetEntity = Tag.class)
    // private @Getter @Setter List<Tag> tagsAssociated;


}