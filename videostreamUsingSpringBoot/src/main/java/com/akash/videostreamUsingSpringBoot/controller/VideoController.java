package com.akash.videostreamUsingSpringBoot.controller;


import com.akash.videostreamUsingSpringBoot.service.VideoServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/api/v1")
public class VideoController {

    @Autowired
    private  VideoServices videoServices;


    @CrossOrigin(origins = "http://localhost:9090/")
    @GetMapping(value = "/watch={name}",produces = "video/mp4")
    public Mono<Resource> getVideoByName(@PathVariable("name") String name, @RequestHeader("Range") String range){
        return videoServices.watchVideo(name);
    }
}
