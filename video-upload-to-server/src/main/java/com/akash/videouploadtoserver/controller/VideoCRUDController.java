package com.akash.videouploadtoserver.controller;


import com.akash.videouploadtoserver.entity.ResourceFile;
import com.akash.videouploadtoserver.service.VideoDeleteService;
import com.akash.videouploadtoserver.service.VideoListService;
import com.akash.videouploadtoserver.service.VideoUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class VideoCRUDController {

    @Autowired
    private VideoUploadService uploadService;

    @Autowired
    private VideoDeleteService videoDeleteService;

    @Autowired
    private VideoListService videoListService;


    @PostMapping(value = "/upload")
    public ResponseEntity<ResourceFile> uploadVideo(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(uploadService.saveVideo(multipartFile));
    }

    @DeleteMapping("/delete&id={id}")
    public ResponseEntity<ResourceFile> deleteVideo(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(videoDeleteService.deleteResourceFile(id));
    }
    @GetMapping("/getallvideo")
    public ResponseEntity<List<ResourceFile>>findAllVideous(){
        return ResponseEntity.status(HttpStatus.OK).body(videoListService.getAllVideos());
    }

    @DeleteMapping (value = "/deleteallvideo")
    public ResponseEntity<List<ResourceFile>> deleteAllVideous(){
        return ResponseEntity.status(HttpStatus.OK).body(videoDeleteService.deleteAllVideous());
    }

}

