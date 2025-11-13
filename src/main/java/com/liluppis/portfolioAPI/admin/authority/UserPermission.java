package com.liluppis.portfolioAPI.admin.authority;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserPermission {

    READ("READ"),
    // TODO - Does write include both POST & PUT?
    WRITE("WRITE"),

    DELETE("DELETE");

    private final String userPermission;
}
