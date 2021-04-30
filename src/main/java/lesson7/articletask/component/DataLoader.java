package lesson7.articletask.component;

import lesson7.articletask.entity.Lavozim;
import lesson7.articletask.entity.User;
import lesson7.articletask.entity.enums.Huquq;
import lesson7.articletask.repository.LavozimRepository;
import lesson7.articletask.repository.UserRepository;
import lesson7.articletask.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LavozimRepository lavozimRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.initialization-mode}")
    private String  initialMode;
    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            Huquq[] huquqList = Huquq.values();
            Lavozim admin = lavozimRepository.save(new Lavozim(AppConstants.ADMIN,
                    Arrays.asList(huquqList.clone()),"sistema egasi"
            ));
            Lavozim user = lavozimRepository.save(new Lavozim(AppConstants.USER,
                    Arrays.asList(Huquq.ADD_COMMENT, Huquq.DELETE_MY_COMMENT, Huquq.EDIT_COMMENT),
                    "oddiy foydalanuvchi"
            ));
            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true
            ));
            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("user123"),
                    user,
                    true
            ));
        }
    }
}
