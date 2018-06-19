package windoctor7.github.io.spring.auth.jwt.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = null;

        if ("jose".equals(username)) {
            user = new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

                    return grantedAuthorities;
                }

                @Override
                public String getPassword() {
                    return "ganfor";
                }

                @Override
                public String getUsername() {
                    return username;
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
            };
        } else {
            throw new UsernameNotFoundException("Usuario inexistente");
        }

        return user;
    }
}
