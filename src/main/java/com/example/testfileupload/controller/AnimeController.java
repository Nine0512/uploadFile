package com.example.testfileupload.controller;

import com.example.testfileupload.DTO.AnimeDTO;
import com.example.testfileupload.DTO.AnimeRespondsDTO;
import com.example.testfileupload.entity.Anime;
import com.example.testfileupload.service.AnimeService;
import com.example.testfileupload.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animes")
public class AnimeController {
    @Autowired
    private AnimeService animeService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @PostMapping
    public AnimeRespondsDTO addAnime(@RequestBody AnimeDTO anime) {
        animeService.addAnime(anime);
        return modelMapper.map(anime, AnimeRespondsDTO.class);
    }

    @GetMapping
    public List<AnimeRespondsDTO> getAllAnime() {
        List<Anime> animes = animeService.getAllAnime();
        return listMapper.mapList(animes, AnimeRespondsDTO.class, modelMapper);
    }

}
