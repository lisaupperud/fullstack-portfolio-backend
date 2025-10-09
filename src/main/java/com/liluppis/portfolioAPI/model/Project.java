package com.liluppis.portfolioAPI.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
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

    public Project() {}

    public Project(String name, String desc, String link, List<String> tags, String iconKey) {
        this.name = name;
        this.desc = desc;
        this.link = link;
        this.tags = tags;
    }

}
