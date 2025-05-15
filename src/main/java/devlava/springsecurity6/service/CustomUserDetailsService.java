package devlava.springsecurity6.service;

import devlava.springsecurity6.entity.User;
import devlava.springsecurity6.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String skid) throws UsernameNotFoundException {
        User user = userRepository.findBySkid(skid)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + skid));

        return new org.springframework.security.core.userdetails.User(
                user.getSkid(),
                "", // 빈 비밀번호
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
    }
}