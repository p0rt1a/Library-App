package com.alper.server.controllers;

import com.alper.server.entities.User;
import com.alper.server.models.LoginModel;
import com.alper.server.models.RegisterModel;
import com.alper.server.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final IAuthService _userService;

    @Autowired
    public AuthController(IAuthService userService) {
        this._userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginModel model) {
        try {
            User user = _userService.login(model);
            return ResponseEntity.ok().body(user);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterModel model) {
        try {
            _userService.register(model);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
