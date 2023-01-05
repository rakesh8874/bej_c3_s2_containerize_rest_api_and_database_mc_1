package com.niit.userlogindetails.controller;

import com.niit.userlogindetails.domain.User;
import com.niit.userlogindetails.service.ISecurityGenerator;
import com.niit.userlogindetails.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    IUserService userService;
    ISecurityGenerator securityGenerator;

    @Autowired
    public UserController(IUserService userService, ISecurityGenerator securityGenerator) {
        this.userService = userService;
        this.securityGenerator = securityGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User userInfo = userService.login(user.getUserId(), user.getUserPassword());
        if(userInfo != null){
            Map<String, String> map = securityGenerator.tockenGenerator(userInfo);
            return  new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid User or User doesn't Exist",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    @DeleteMapping("user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }
}
