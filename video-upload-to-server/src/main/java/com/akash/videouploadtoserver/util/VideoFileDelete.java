package com.akash.videouploadtoserver.util;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

public class VideoFileDelete {

    private final String FOLDER_PATH="/home/gary-lovegod/Documents/Test/%s.mp4";

    public void deleteVideoFile(String fileName){
        String fullPath= String.format(FOLDER_PATH,fileName);
        File file = new File(fullPath);
        if(file.delete()){
            System.out.println("File Deleted");
        }else {
            throw new RuntimeException("File Not Found in the Storage");
        }
    }

    public void deleteAllVideos(List<String> fileNames){
        fileNames.forEach((n)-> {
            File file = new File(String.format(FOLDER_PATH, n));
            if(file.delete()){
                System.out.println("File deleted :" + n);
            }else {
                throw new RuntimeException("File not found in the Storage");
            }
        }
            );

    }
}
