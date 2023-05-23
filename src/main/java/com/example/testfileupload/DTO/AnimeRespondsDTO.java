package com.example.testfileupload.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimeRespondsDTO {
    private Integer animeId;
    private String animeName;
    @JsonProperty("categoryName")
    private String categoryCategoryName;
}
