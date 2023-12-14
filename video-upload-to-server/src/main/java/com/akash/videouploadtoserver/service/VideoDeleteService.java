package com.akash.videouploadtoserver.service;

import com.akash.videouploadtoserver.entity.ResourceFile;

import java.util.List;

public interface VideoDeleteService {
    public ResourceFile deleteResourceFile(String id);
    public List<ResourceFile> deleteAllVideous();
}
