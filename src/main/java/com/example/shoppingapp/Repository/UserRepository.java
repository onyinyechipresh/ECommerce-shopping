package com.example.shoppingapp.Repository;

import com.example.shoppingapp.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersModel,Integer>{

    Optional<UsersModel>findByLoginAndPassword(String login, String password);
    Optional<UsersModel>findFirstByLogin(String login);
}
