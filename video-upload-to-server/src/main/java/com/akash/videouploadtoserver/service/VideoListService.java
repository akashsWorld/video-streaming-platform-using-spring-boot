package com.akash.videouploadtoserver.service;

import com.akash.videouploadtoserver.entity.ResourceFile;

import java.util.List;

public interface VideoListService {
    List<ResourceFile> getAllVideos();
}
