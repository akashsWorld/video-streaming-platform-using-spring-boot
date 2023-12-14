package com.akash.videouploadtoserver.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "resouce_file")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResourceFile {

    @Id
    private String id;
    private String fileName;
    private String fileLocation;
    private String fileType;
}
