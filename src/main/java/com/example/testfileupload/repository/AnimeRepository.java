package com.example.testfileupload.repository;

import com.example.testfileupload.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Integer>{
}
