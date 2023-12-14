package com.akash.videouploadtoserver.repository;

import com.akash.videouploadtoserver.entity.ResourceFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideRepository  extends MongoRepository<ResourceFile,String> {
}
