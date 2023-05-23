package com.example.testfileupload.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {
    @Id
    private Integer categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Anime> animeList;
}
