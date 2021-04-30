package lesson7.articletask.controller;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.User;
import lesson7.articletask.payload.LoginDto;
import lesson7.articletask.payload.RegisterDto;
import lesson7.articletask.payload.StaffDto;
import lesson7.articletask.security.JwtProvider;
import lesson7.articletask.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
   @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto){
   ApiResponse apiResponse=authService.registerUser(registerDto);
   return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }
   @PostMapping("/login")
    public HttpEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto){
       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
     User user=(User) authentication.getPrincipal();
       String token = jwtProvider.generateToken(user.getUsername(), user.getLavozim());
   return ResponseEntity.ok(token);
   }
   @PostMapping("/register/staff")
    public HttpEntity<?> registerStaff(@Valid @RequestBody StaffDto staffDto){
       ApiResponse apiResponse=authService.registerStaff(staffDto);
       return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }
}
