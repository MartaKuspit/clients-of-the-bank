package my.project.userAccess;


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "app_users")
public class User  { //implements UserDetails
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public User(String username, String password,  String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role));
//    }

    public String getRole() {
        return role;
    }

    //@Override
    public String getPassword() {
        return password;
    }

    //@Override
    public String getUsername() {
        return username;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
