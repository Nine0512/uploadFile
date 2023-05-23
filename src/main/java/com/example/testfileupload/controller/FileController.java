package com.example.testfileupload.controller;

import com.example.testfileupload.entity.Anime;
import com.example.testfileupload.service.AnimeService;
import com.example.testfileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @Autowired
    public AnimeService animeService;

    @PostMapping("")
    public String fileUpload(@RequestParam("file") MultipartFile file,
                             @RequestParam("animeId") Integer animeId) {
//        fileService.store(file);
        Anime anime = animeService.getAnimeById(animeId);
        anime.setAnimeImgPath(fileService.store(file));
        animeService.updateAnime(anime);
        return "You successfully uploaded !" + file.getOriginalFilename();
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileService.loadFileAsResource(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }

    @DeleteMapping("/{filename:.+}")
    public String deleteFile(@PathVariable String filename) {
        fileService.deleteFile(filename);
        return "You successfully deleted " + filename;
    }
}
