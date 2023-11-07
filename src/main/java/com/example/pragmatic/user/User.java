package com.example.pragmatic.user;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Essential Info
    @Column(nullable = false, unique = true, length=100)
    private String userid;
    private String userpw;

    // Property Info
    private String role;
    private String status;

    // Additional Info
    private String name;
    private String nickname;
    private String email;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateUpdated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() { return null; }
    @Override
    public String getPassword() { return null; }
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    @Override
    public boolean isAccountNonLocked() { return false; }
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    @Override
    public boolean isEnabled() {
        return false;
    }
}