package com.alper.server.services;

import com.alper.server.entities.User;
import com.alper.server.models.LoginModel;
import com.alper.server.models.RegisterModel;

public interface IAuthService {
    public User login(LoginModel model);
    public void register(RegisterModel model);
}
