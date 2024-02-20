package com.bs23.ecommerce.domain;

import static com.bs23.ecommerce.domain.ApplicationUserTestSamples.*;
import static com.bs23.ecommerce.domain.RoleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.bs23.ecommerce.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RoleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Role.class);
        Role role1 = getRoleSample1();
        Role role2 = new Role();
        assertThat(role1).isNotEqualTo(role2);

        role2.setId(role1.getId());
        assertThat(role1).isEqualTo(role2);

        role2 = getRoleSample2();
        assertThat(role1).isNotEqualTo(role2);
    }

    @Test
    void applicationUsersTest() throws Exception {
        Role role = getRoleRandomSampleGenerator();
        ApplicationUser applicationUserBack = getApplicationUserRandomSampleGenerator();

        role.addApplicationUsers(applicationUserBack);
        assertThat(role.getApplicationUsers()).containsOnly(applicationUserBack);
        assertThat(applicationUserBack.getRoles()).containsOnly(role);

        role.removeApplicationUsers(applicationUserBack);
        assertThat(role.getApplicationUsers()).doesNotContain(applicationUserBack);
        assertThat(applicationUserBack.getRoles()).doesNotContain(role);

        role.applicationUsers(new HashSet<>(Set.of(applicationUserBack)));
        assertThat(role.getApplicationUsers()).containsOnly(applicationUserBack);
        assertThat(applicationUserBack.getRoles()).containsOnly(role);

        role.setApplicationUsers(new HashSet<>());
        assertThat(role.getApplicationUsers()).doesNotContain(applicationUserBack);
        assertThat(applicationUserBack.getRoles()).doesNotContain(role);
    }
}
