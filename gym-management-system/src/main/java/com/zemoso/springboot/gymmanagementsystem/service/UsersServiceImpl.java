package com.zemoso.springboot.gymmanagementsystem.service;

import com.zemoso.springboot.gymmanagementsystem.dao.UsersRepository;
import com.zemoso.springboot.gymmanagementsystem.entity.Users;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findById(String name) {

        Optional<Users> result = usersRepository.findById(name);
        Users users = null;
        if(result.isEmpty()){
            log.error("Invalid User name - "+ name);
            throw new RuntimeException("Invalid user name - "+ name);
        }

        users = result.get();
        return users;
    }

    @Override
    public void save(Users user) {
        usersRepository.save(user);
    }
}
