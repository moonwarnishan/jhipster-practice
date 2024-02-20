package com.bs23.ecommerce.service.mapper;

import com.bs23.ecommerce.domain.ApplicationUser;
import com.bs23.ecommerce.domain.Role;
import com.bs23.ecommerce.service.dto.ApplicationUserDTO;
import com.bs23.ecommerce.service.dto.RoleDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ApplicationUser} and its DTO {@link ApplicationUserDTO}.
 */
@Mapper(componentModel = "spring")
public interface ApplicationUserMapper extends EntityMapper<ApplicationUserDTO, ApplicationUser> {
    @Mapping(target = "roles", source = "roles", qualifiedByName = "roleIdSet")
    ApplicationUserDTO toDto(ApplicationUser s);

    @Mapping(target = "removeRoles", ignore = true)
    ApplicationUser toEntity(ApplicationUserDTO applicationUserDTO);

    @Named("roleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RoleDTO toDtoRoleId(Role role);

    @Named("roleIdSet")
    default Set<RoleDTO> toDtoRoleIdSet(Set<Role> role) {
        return role.stream().map(this::toDtoRoleId).collect(Collectors.toSet());
    }
}
