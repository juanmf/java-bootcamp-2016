package com.bootcamp.FinalProject.service;

import com.bootcamp.FinalProject.entity.User;

public interface ISiteService {

    public boolean login(User user);

    public boolean logout(User user);

}
