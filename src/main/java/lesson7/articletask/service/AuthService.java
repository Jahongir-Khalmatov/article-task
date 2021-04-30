package lesson7.articletask.service;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.Lavozim;
import lesson7.articletask.entity.User;
import lesson7.articletask.exceptions.ResurceNotFoundException;
import lesson7.articletask.payload.RegisterDto;
import lesson7.articletask.payload.StaffDto;
import lesson7.articletask.repository.LavozimRepository;
import lesson7.articletask.repository.UserRepository;
import lesson7.articletask.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LavozimRepository lavozimRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public ApiResponse registerUser(RegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getPrePassword()))
            return new ApiResponse(false,"parol mos kelmadi");
        boolean exists = userRepository.existsByUsername(registerDto.getUsername());
    if (exists)
        return new ApiResponse(false,"Bunday username mavjud");
        User user = new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                lavozimRepository.findByName(AppConstants.USER).orElseThrow(() -> new ResurceNotFoundException("lavozim","name",AppConstants.USER)),
                true
        );
        userRepository.save(user);
        return new ApiResponse(true,"muvaffaqiyatli ro'yxatdan o'tdingiz");
    }

    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public ApiResponse registerStaff(StaffDto staffDto) {
        Optional<User> optionalUser = userRepository.findByUsername(staffDto.getUsername());
        if (!optionalUser.isPresent())
            return new ApiResponse(false,"bunday user mavjud emas");
        User user = optionalUser.get();
        user.setUsername(staffDto.getUsername());
        Optional<Lavozim> optionalLavozim = lavozimRepository.findById(Long.valueOf(staffDto.getLavozimId()));
        Lavozim lavozim = optionalLavozim.get();
        user.setLavozim(lavozim);
        userRepository.save(user);
        return new ApiResponse(true,"muvaffaqiyatli ro'yxatdan o'tdingiz");

    }

    }

