package com.akash.videouploadtoserver.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class VideoFileSave {

    private final String FILE_PATH="/home/gary-lovegod/Documents/Test/";

    public String saveFileInSystem(MultipartFile multipartFile) throws IOException {
        UUID uuid = UUID.randomUUID();
        String unique=uuid+multipartFile.getOriginalFilename();
        String fullpath = FILE_PATH+unique;
        multipartFile.transferTo(new File(fullpath));
        return unique;
    }
}
