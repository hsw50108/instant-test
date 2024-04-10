package com.example.instanttest.service.user;

import com.example.instanttest.api.user.request.CustomUserDetails;
import com.example.instanttest.domain.user.User;
import com.example.instanttest.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userData = userRepository.findByEmail(email);

        if (userData == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }


        return new CustomUserDetails(userData);
    }


}
