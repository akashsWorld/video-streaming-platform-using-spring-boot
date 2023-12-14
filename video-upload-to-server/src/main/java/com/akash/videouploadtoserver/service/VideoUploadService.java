package com.akash.videouploadtoserver.service;

import com.akash.videouploadtoserver.entity.ResourceFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VideoUploadService {

    ResourceFile saveVideo(MultipartFile multipartFile) throws IOException;
}
