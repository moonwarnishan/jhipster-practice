package com.bs23.ecommerce.domain;

import static com.bs23.ecommerce.domain.AddressTestSamples.*;
import static com.bs23.ecommerce.domain.ApplicationUserTestSamples.*;
import static com.bs23.ecommerce.domain.OrderTestSamples.*;
import static com.bs23.ecommerce.domain.RoleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.bs23.ecommerce.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ApplicationUserTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ApplicationUser.class);
        ApplicationUser applicationUser1 = getApplicationUserSample1();
        ApplicationUser applicationUser2 = new ApplicationUser();
        assertThat(applicationUser1).isNotEqualTo(applicationUser2);

        applicationUser2.setId(applicationUser1.getId());
        assertThat(applicationUser1).isEqualTo(applicationUser2);

        applicationUser2 = getApplicationUserSample2();
        assertThat(applicationUser1).isNotEqualTo(applicationUser2);
    }

    @Test
    void addressesTest() throws Exception {
        ApplicationUser applicationUser = getApplicationUserRandomSampleGenerator();
        Address addressBack = getAddressRandomSampleGenerator();

        applicationUser.addAddresses(addressBack);
        assertThat(applicationUser.getAddresses()).containsOnly(addressBack);
        assertThat(addressBack.getApplicationUser()).isEqualTo(applicationUser);

        applicationUser.removeAddresses(addressBack);
        assertThat(applicationUser.getAddresses()).doesNotContain(addressBack);
        assertThat(addressBack.getApplicationUser()).isNull();

        applicationUser.addresses(new HashSet<>(Set.of(addressBack)));
        assertThat(applicationUser.getAddresses()).containsOnly(addressBack);
        assertThat(addressBack.getApplicationUser()).isEqualTo(applicationUser);

        applicationUser.setAddresses(new HashSet<>());
        assertThat(applicationUser.getAddresses()).doesNotContain(addressBack);
        assertThat(addressBack.getApplicationUser()).isNull();
    }

    @Test
    void rolesTest() throws Exception {
        ApplicationUser applicationUser = getApplicationUserRandomSampleGenerator();
        Role roleBack = getRoleRandomSampleGenerator();

        applicationUser.addRoles(roleBack);
        assertThat(applicationUser.getRoles()).containsOnly(roleBack);

        applicationUser.removeRoles(roleBack);
        assertThat(applicationUser.getRoles()).doesNotContain(roleBack);

        applicationUser.roles(new HashSet<>(Set.of(roleBack)));
        assertThat(applicationUser.getRoles()).containsOnly(roleBack);

        applicationUser.setRoles(new HashSet<>());
        assertThat(applicationUser.getRoles()).doesNotContain(roleBack);
    }

    @Test
    void ordersTest() throws Exception {
        ApplicationUser applicationUser = getApplicationUserRandomSampleGenerator();
        Order orderBack = getOrderRandomSampleGenerator();

        applicationUser.addOrders(orderBack);
        assertThat(applicationUser.getOrders()).containsOnly(orderBack);
        assertThat(orderBack.getApplicationUser()).isEqualTo(applicationUser);

        applicationUser.removeOrders(orderBack);
        assertThat(applicationUser.getOrders()).doesNotContain(orderBack);
        assertThat(orderBack.getApplicationUser()).isNull();

        applicationUser.orders(new HashSet<>(Set.of(orderBack)));
        assertThat(applicationUser.getOrders()).containsOnly(orderBack);
        assertThat(orderBack.getApplicationUser()).isEqualTo(applicationUser);

        applicationUser.setOrders(new HashSet<>());
        assertThat(applicationUser.getOrders()).doesNotContain(orderBack);
        assertThat(orderBack.getApplicationUser()).isNull();
    }
}
