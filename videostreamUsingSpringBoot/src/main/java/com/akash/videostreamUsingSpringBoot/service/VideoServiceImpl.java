package com.akash.videostreamUsingSpringBoot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VideoServiceImpl implements VideoServices {
   private final String FILEPATH="file:/home/gary-lovegod/Documents/Test/%s.mp4";

   @Autowired
   private ResourceLoader resourceLoader;



   @Override
   public Mono<Resource> watchVideo(String fileName) {
      return Mono.fromSupplier(()->resourceLoader.getResource(String.format(FILEPATH,fileName)));
   }

}
