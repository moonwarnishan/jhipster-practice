package com.bs23.ecommerce.service.mapper;

import com.bs23.ecommerce.domain.Role;
import com.bs23.ecommerce.service.dto.RoleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Role} and its DTO {@link RoleDTO}.
 */
@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {}
