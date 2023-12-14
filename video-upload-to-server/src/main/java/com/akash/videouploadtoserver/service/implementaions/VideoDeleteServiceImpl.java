package com.akash.videouploadtoserver.service.implementaions;

import com.akash.videouploadtoserver.entity.ResourceFile;
import com.akash.videouploadtoserver.repository.VideRepository;
import com.akash.videouploadtoserver.service.VideoDeleteService;
import com.akash.videouploadtoserver.util.ResourceToStringList;
import com.akash.videouploadtoserver.util.VideoFileDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VideoDeleteServiceImpl implements VideoDeleteService {

    @Autowired
    private VideRepository videRepository;

    @Autowired
    private VideoFileDelete videoFileDelete;

    @Autowired
    private ResourceToStringList resourceToStringList;

    public ResourceFile deleteResourceFile(String id){

       Optional<ResourceFile> resourceFile= videRepository.findById(id);

       if(resourceFile.isPresent()){
           ResourceFile resourceFile1 = resourceFile.get();
           videoFileDelete.deleteVideoFile(resourceFile1.getFileName());
           videRepository.deleteById(resourceFile1.getId());
       }else {
           throw new RuntimeException("Not Found in the DataBase");
       }
       return resourceFile.get();
    }

    @Override
    public List<ResourceFile> deleteAllVideous() {
        List<ResourceFile> resourceFiles = videRepository.findAll();
        if(!resourceFiles.isEmpty()){
            List<String> nameList = resourceToStringList.getListOfNames(resourceFiles);
            videoFileDelete.deleteAllVideos(nameList);
            videRepository.deleteAll();
        }

        return resourceFiles;
    }


}
