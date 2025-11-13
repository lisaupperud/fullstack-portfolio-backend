package com.liluppis.portfolioAPI.admin.authority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.liluppis.portfolioAPI.admin.authority.UserPermission.*;

@AllArgsConstructor
@Getter
public enum UserRole {
    GUEST(
            UserRoleName.GUEST.getRoleName(),
            Set.of(READ)
    ),

    ADMIN(
            UserRoleName.ADMIN.getRoleName(),
            Set.of(
                    READ,
                    WRITE,
                    DELETE
            )
    );

    private final String roleName;
    private final Set<UserPermission> userPermissions;

    public List<SimpleGrantedAuthority> getUserAuthorities() {

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        // this == the choice made after UserRole. (e.g: UserRole.ADMIN)
        authorityList.add(new SimpleGrantedAuthority(this.roleName));
        // add Permissions
        authorityList.addAll(
                this.userPermissions.stream().map(
                        userPermission -> new SimpleGrantedAuthority(userPermission.getUserPermission())
                ).toList()
        );

        return authorityList;
    }
}
