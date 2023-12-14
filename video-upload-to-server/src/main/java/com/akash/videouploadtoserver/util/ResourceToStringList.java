package com.akash.videouploadtoserver.util;


import com.akash.videouploadtoserver.entity.ResourceFile;

import java.util.ArrayList;
import java.util.List;

public class ResourceToStringList {

    public List<String> getListOfNames(List<ResourceFile> resourceFiles){
        List<String> strList = new ArrayList<>();

        resourceFiles.stream().forEach(resourceFile -> {
            strList.add(resourceFile.getFileName());
        });
        return strList;
    }
}
