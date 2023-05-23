package com.example.testfileupload.service;

import com.example.testfileupload.DTO.AnimeDTO;
import com.example.testfileupload.entity.Anime;
import com.example.testfileupload.repository.AnimeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private FileService fileService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;

    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public Anime getAnimeById(Integer animeId) {
        return animeRepository.findById(animeId).orElse(null);
    }

    public AnimeDTO addAnime(AnimeDTO anime) {
        Anime newAnime = modelMapper.map(anime, Anime.class);
        newAnime.setCategory(categoryService.findById(anime.getCategoryCategoryId()));
        animeRepository.save(newAnime);
        return anime;
    }

    public Anime updateAnime(Anime anime) {
        Anime existingAnime = animeRepository.findById(anime.getAnimeId()).orElse(null);
        existingAnime.setAnimeName(anime.getAnimeName());
        existingAnime.setAnimeImgPath(anime.getAnimeImgPath());
        existingAnime.setCategory(anime.getCategory());
        return animeRepository.save(existingAnime);
    }
}
