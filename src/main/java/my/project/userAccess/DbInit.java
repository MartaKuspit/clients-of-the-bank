package my.project.userAccess;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void onInit() {

        User user1 = new User(
                "admin1",
                passwordEncoder.encode("admin"),
                "ADMIN"
        );
        userRepository.save(user1);
    }

}

