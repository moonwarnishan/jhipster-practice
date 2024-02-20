package com.bs23.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A ApplicationUser.
 */
@Entity
@Table(name = "application_user")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationUser")
    @JsonIgnoreProperties(value = { "applicationUser" }, allowSetters = true)
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "rel_application_user__roles",
        joinColumns = @JoinColumn(name = "application_user_id"),
        inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    @JsonIgnoreProperties(value = { "applicationUsers" }, allowSetters = true)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationUser")
    @JsonIgnoreProperties(value = { "applicationUser" }, allowSetters = true)
    private Set<Order> orders = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ApplicationUser id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public ApplicationUser username(String username) {
        this.setUsername(username);
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public ApplicationUser email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public ApplicationUser phone(String phone) {
        this.setPhone(phone);
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        if (this.addresses != null) {
            this.addresses.forEach(i -> i.setApplicationUser(null));
        }
        if (addresses != null) {
            addresses.forEach(i -> i.setApplicationUser(this));
        }
        this.addresses = addresses;
    }

    public ApplicationUser addresses(Set<Address> addresses) {
        this.setAddresses(addresses);
        return this;
    }

    public ApplicationUser addAddresses(Address address) {
        this.addresses.add(address);
        address.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeAddresses(Address address) {
        this.addresses.remove(address);
        address.setApplicationUser(null);
        return this;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public ApplicationUser roles(Set<Role> roles) {
        this.setRoles(roles);
        return this;
    }

    public ApplicationUser addRoles(Role role) {
        this.roles.add(role);
        return this;
    }

    public ApplicationUser removeRoles(Role role) {
        this.roles.remove(role);
        return this;
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        if (this.orders != null) {
            this.orders.forEach(i -> i.setApplicationUser(null));
        }
        if (orders != null) {
            orders.forEach(i -> i.setApplicationUser(this));
        }
        this.orders = orders;
    }

    public ApplicationUser orders(Set<Order> orders) {
        this.setOrders(orders);
        return this;
    }

    public ApplicationUser addOrders(Order order) {
        this.orders.add(order);
        order.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeOrders(Order order) {
        this.orders.remove(order);
        order.setApplicationUser(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUser)) {
            return false;
        }
        return getId() != null && getId().equals(((ApplicationUser) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUser{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }
}
