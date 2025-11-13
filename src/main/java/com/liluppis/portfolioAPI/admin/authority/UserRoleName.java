package com.liluppis.portfolioAPI.admin.authority;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRoleName {

    GUEST("ROLE_GUEST"),
    ADMIN("ROLE_ADMIN");

    private final String roleName;

}
