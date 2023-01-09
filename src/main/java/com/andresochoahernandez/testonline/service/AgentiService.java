package com.andresochoahernandez.testonline.service;

import com.andresochoahernandez.testonline.model.agents.User;
import com.andresochoahernandez.testonline.repository.agents.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class AgentiService implements UserDetailsService {
    private final UserRepository users;

    public AgentiService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.findByUsername(username).map(SecureUser::new).orElseThrow(() -> new UsernameNotFoundException("L'username inserito non è presente nel sistema " + username));
    }

    private class SecureUser implements UserDetails {
        private final User user;

        public SecureUser(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Arrays.stream(this.user.getRoles().split(",")).map(SimpleGrantedAuthority::new).toList();
        }

        @Override
        public String getPassword() {
            return this.user.getPassword();
        }

        @Override
        public String getUsername() {
            return this.user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
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
            return true;
        }
    }
}
