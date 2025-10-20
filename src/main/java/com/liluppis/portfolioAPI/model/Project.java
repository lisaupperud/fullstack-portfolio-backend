package com.liluppis.portfolioAPI.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Builder
@Document(collection = "projects")
public record Project(
        @Id
        String id,
        @Field(name = "projectName")
        String name,
        @Field(name = "description")
        String desc,
        @Field(name = "link")
        String link,
        @Field(name = "tags")
        List<String> tags,
        @Field(name = "iconKey")
        String iconKey
) {
}
