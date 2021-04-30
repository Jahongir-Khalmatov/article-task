package lesson7.articletask.controller;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.payload.UserDto;
import lesson7.articletask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public HttpEntity<?> registerUSer(@Valid @RequestBody UserDto userDto, HttpServletRequest request){
        ApiResponse apiResponse = userService.addUser(request,userDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:401).body(apiResponse);
    }
}
