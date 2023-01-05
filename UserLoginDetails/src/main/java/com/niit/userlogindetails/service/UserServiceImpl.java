package com.niit.userlogindetails.service;
import com.niit.userlogindetails.domain.User;
import com.niit.userlogindetails.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        if(userRepository.findById(user.getUserId()).isPresent()){
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User login(String userId, String userPassword) {
        if(userRepository.findById(userId).isPresent()){

            User user = userRepository.findById(userId).get();

            if(user.getUserPassword().equals(userPassword)){
                return user;
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
