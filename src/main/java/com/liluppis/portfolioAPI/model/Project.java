package com.liluppis.portfolioAPI.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "projects")
public class Project {

    @Id
    private String id;
    @Field(name = "projectName")
    private String name;
    @Field(name = "description")
    private String desc;
    @Field(name = "link")
    private String link;
    @Field(name = "tags")
    private List<String> tags;
    @Field(name = "iconKey")
    private String iconKey;

}
