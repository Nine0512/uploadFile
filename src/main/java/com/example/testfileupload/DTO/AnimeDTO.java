package com.example.testfileupload.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimeDTO {
    private Integer animeId;
    private String animeName;
    @JsonProperty("categoryId")
    private Integer categoryCategoryId;
}
