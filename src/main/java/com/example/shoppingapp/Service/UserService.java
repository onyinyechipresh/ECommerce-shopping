package com.example.shoppingapp.Service;

import com.example.shoppingapp.Repository.UserRepository;
import com.example.shoppingapp.model.Products;
import com.example.shoppingapp.model.UsersModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersModel registerUser(String login, String password, String email){
        if(login == null || password == null){
            return null;
        }
        else{
            if(userRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return userRepository.save(usersModel);
        }
    }

    public UsersModel authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login,password).orElse(null);
    }


}
