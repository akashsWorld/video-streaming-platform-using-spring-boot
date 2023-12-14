package com.akash.videostreamUsingSpringBoot.service;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;


public interface VideoServices {

//    Resource saveVideo(MultipartFile file) throws IOException;
    Mono<Resource> watchVideo(String fileName);

}
