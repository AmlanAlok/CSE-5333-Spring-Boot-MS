package com.cloud.controller;


import com.cloud.modal.LoginInput;
import com.cloud.service.LoginService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    public LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<JSONObject> login(@RequestBody LoginInput loginInput){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        logger.info(loginInput.toString());

        return loginService.loginUser(loginInput);
    }
}
