package lesson7.articletask.service;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.User;
import lesson7.articletask.payload.UserDto;
import lesson7.articletask.repository.UserRepository;
import lesson7.articletask.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtProvider jwtProvider;
    public ApiResponse addUser(HttpServletRequest request,UserDto userDto) {
//        String token = request.getHeader(("Authorization"));
//        token=token.substring(7);
//        String username = jwtProvider.getUsernameFromToken(token);
//        boolean exists = userRepository.existsByUsername(userDto.getUsername());
//        if (exists)
//            return new ApiResponse(false,"Bunday username mavjud");
//        User user = new User();
//        user.setUsername(userDto.getUsername());

return new ApiResponse();
    }
}
