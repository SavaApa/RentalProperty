package com.example.rentalproperty.security;

import com.example.rentalproperty.entity.Role;
import com.example.rentalproperty.entity.UserInfo;
import com.example.rentalproperty.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(name);

        if (userInfo.isEmpty()) {
            throw new UsernameNotFoundException("User with login '" + name + "' not found");
        }

        return User.withUsername(name)
                .username(userInfo.get().getUserName())
                .password(userInfo.get().getPassword())
                .authorities(getAuthorities(userInfo.get().getRoles()))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));
            role.getAuthorities()
                    .forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName())));
        }

        return authorities;
    }
}




