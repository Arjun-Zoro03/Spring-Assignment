package com.zemoso.springboot.gymmanagementsystem.service;

import com.zemoso.springboot.gymmanagementsystem.entity.Users;

public interface UsersService {
    public Users findById(String name);
    public void save(Users user);
}
