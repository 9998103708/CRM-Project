package com.CRM.Customer.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CRM.Customer.Repository.userrepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final userrepository userRepository;

    public UserDetailsServiceImpl(userrepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.CRM.Customer.Entity.User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().toUpperCase()) // Ensure this is a valid role like "USER"
                .build();
    }
}
