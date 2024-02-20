package com.bs23.ecommerce.service.mapper;

import com.bs23.ecommerce.domain.ApplicationUser;
import com.bs23.ecommerce.domain.Order;
import com.bs23.ecommerce.service.dto.ApplicationUserDTO;
import com.bs23.ecommerce.service.dto.OrderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Order} and its DTO {@link OrderDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
    @Mapping(target = "applicationUser", source = "applicationUser", qualifiedByName = "applicationUserId")
    OrderDTO toDto(Order s);

    @Named("applicationUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ApplicationUserDTO toDtoApplicationUserId(ApplicationUser applicationUser);
}
