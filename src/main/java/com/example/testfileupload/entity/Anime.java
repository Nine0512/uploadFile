package com.example.testfileupload.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "anime")
public class Anime {
    @Id
    private Integer animeId;
    private String animeName;
    private String animeImgPath;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;
}
