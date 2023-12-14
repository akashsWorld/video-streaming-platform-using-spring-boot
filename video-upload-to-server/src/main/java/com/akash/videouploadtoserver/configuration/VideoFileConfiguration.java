package com.akash.videouploadtoserver.configuration;

import com.akash.videouploadtoserver.util.ResourceToStringList;
import com.akash.videouploadtoserver.util.VideoFileDelete;
import com.akash.videouploadtoserver.util.VideoFileSave;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoFileConfiguration {

    @Bean
    public VideoFileSave getVideFileSave(){return new VideoFileSave();}

    @Bean
    public VideoFileDelete getVideoFiledelete(){
        return new VideoFileDelete();
    }

    @Bean
    public ResourceToStringList getVideoServiceToList(){
        return new ResourceToStringList();
    }

}
