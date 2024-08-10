package com.alper.server.services.impl;

import com.alper.server.entities.User;
import com.alper.server.models.LoginModel;
import com.alper.server.models.RegisterModel;
import com.alper.server.repositories.IUserRepository;
import com.alper.server.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private final IUserRepository _userRepository;

    @Autowired
    public AuthServiceImpl(IUserRepository userRepository) {
        this._userRepository = userRepository;
    }

    @Override
    public User login(LoginModel model) {
        //TODO encrypted pwd validation
        return _userRepository.findByUsernameAndPassword(model.getUsername(), model.getPassword()).orElseThrow();
    }

    @Override
    public void register(RegisterModel model) {
        //TODO encrypt pwd
        //TODO check is user already exists
        User user = User.builder().username(model.getUsername()).password(model.getPassword()).email(model.getEmail()).build();
        _userRepository.save(user);
    }
}
