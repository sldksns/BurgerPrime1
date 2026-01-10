package org.example.burgerprime.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.example.burgerprime.models.enums.Role;
import java.util.*;

@Entity
@Table(name = "accounts")
@Data
@RequiredArgsConstructor
public class Account implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    @Column(name = "password", length = 1000)
    private String password;
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
