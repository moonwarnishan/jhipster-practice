package com.bs23.ecommerce.service.mapper;

import com.bs23.ecommerce.domain.Address;
import com.bs23.ecommerce.domain.ApplicationUser;
import com.bs23.ecommerce.service.dto.AddressDTO;
import com.bs23.ecommerce.service.dto.ApplicationUserDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    @Mapping(target = "applicationUser", source = "applicationUser", qualifiedByName = "applicationUserId")
    AddressDTO toDto(Address s);

    @Named("applicationUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ApplicationUserDTO toDtoApplicationUserId(ApplicationUser applicationUser);
}
