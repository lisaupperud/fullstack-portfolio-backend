package com.liluppis.portfolioAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String name;
    private String desc;
    private String link;
    private List<String> tags;
    private String iconKey;
}
