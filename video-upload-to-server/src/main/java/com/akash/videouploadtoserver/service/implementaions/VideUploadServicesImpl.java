package com.akash.videouploadtoserver.service.implementaions;

import com.akash.videouploadtoserver.entity.ResourceFile;
import com.akash.videouploadtoserver.repository.VideRepository;
import com.akash.videouploadtoserver.service.VideoUploadService;
import com.akash.videouploadtoserver.util.VideoFileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class VideUploadServicesImpl implements VideoUploadService {

    @Autowired
    private VideRepository videRepository;

    @Autowired
    private VideoFileSave videoFileSave;


    @Override
    public ResourceFile saveVideo(MultipartFile multipartFile) throws IOException {

        String fileName= videoFileSave.saveFileInSystem(multipartFile);

        ResourceFile resourceFile =
                ResourceFile.builder()
                        .fileName(fileName.replace(".mp4",""))
                        .fileLocation("/")
                        .fileType(multipartFile.getContentType()).build();

        return videRepository.save(resourceFile);
    }
}
