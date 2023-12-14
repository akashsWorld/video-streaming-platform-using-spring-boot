package com.akash.videouploadtoserver.service.implementaions;

import com.akash.videouploadtoserver.entity.ResourceFile;
import com.akash.videouploadtoserver.repository.VideRepository;
import com.akash.videouploadtoserver.service.VideoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoListServiceImpl implements VideoListService {

    @Autowired
    private VideRepository repository;
    @Override
    public List<ResourceFile> getAllVideos() {
        return repository.findAll();
    }
}
