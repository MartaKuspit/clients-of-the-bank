package my.project.userAccess;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.List;

@CrossOrigin("https://clients-of-the-bank.herokuapp.com/")
@RestController
public class UserAccessController {
    private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

    public UserAccessController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("user/user-list")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("user/{id}")
    public User getById(@PathVariable long id) {
        return userRepository.findById(id).get();
    }

//    @PostMapping("/login")
//    public User login() {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Authentication authentication = securityContext.getAuthentication();
//        String username = authentication.getName();
//        String role = authentication.getAuthorities()
//                .stream().findFirst().get()
//                .getAuthority();
//        return new User(username, role);
//    }

    @PostMapping("user/add-new-user")
    public User addNewUser(@Validated @RequestBody User user) {
        String pass = passwordEncoder.encode(user.getPassword());

        user.setPassword(pass);
//        User user1 = new User(
//                user.getUsername(),
//                passwordEncoder.encode(user.getPassword()),
//                user.getRole()
//        );

//        User user1 = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()),
//                user.getRole().toUpperCase());
        String role = user.getRole().toUpperCase();
        user.setRole(role);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    @DeleteMapping("delete-user/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return  NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}

