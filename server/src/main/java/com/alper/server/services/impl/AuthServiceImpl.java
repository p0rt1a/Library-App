package com.alper.server.services.impl;

import com.alper.server.entities.User;
import com.alper.server.models.LoginModel;
import com.alper.server.models.RegisterModel;
import com.alper.server.repositories.IUserRepository;
import com.alper.server.services.IAuthService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {
    private final IUserRepository _userRepository;

    @Autowired
    public AuthServiceImpl(IUserRepository userRepository) {
        this._userRepository = userRepository;
    }

    @Override
    public User login(LoginModel model) throws Exception {
        Optional<User> user = _userRepository.findByUsername(model.getUsername());
        if (user.isEmpty()) {
            throw new Exception("User not found!");
        }
        boolean isPasswordMatch = BCrypt.checkpw(model.getPassword(), user.get().getPassword());

        if (!isPasswordMatch) {
            throw new Exception("Invalid username or password!");
        }

        return user.get();
    }

    @Override
    public void register(RegisterModel model) throws Exception {
        Optional<User> user = _userRepository.findByUsername(model.getUsername());
        if (user.isPresent()) {
            throw new Exception("User is already exists!");
        }
        String hashedPwd = BCrypt.hashpw(model.getPassword(), BCrypt.gensalt());
        User createdUser = User.builder().username(model.getUsername()).password(hashedPwd).email(model.getEmail()).build();
        _userRepository.save(createdUser);
    }
}
