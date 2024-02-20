package com.bs23.ecommerce.domain;

import static com.bs23.ecommerce.domain.AddressTestSamples.*;
import static com.bs23.ecommerce.domain.ApplicationUserTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.bs23.ecommerce.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Address.class);
        Address address1 = getAddressSample1();
        Address address2 = new Address();
        assertThat(address1).isNotEqualTo(address2);

        address2.setId(address1.getId());
        assertThat(address1).isEqualTo(address2);

        address2 = getAddressSample2();
        assertThat(address1).isNotEqualTo(address2);
    }

    @Test
    void applicationUserTest() throws Exception {
        Address address = getAddressRandomSampleGenerator();
        ApplicationUser applicationUserBack = getApplicationUserRandomSampleGenerator();

        address.setApplicationUser(applicationUserBack);
        assertThat(address.getApplicationUser()).isEqualTo(applicationUserBack);

        address.applicationUser(null);
        assertThat(address.getApplicationUser()).isNull();
    }
}
