package com.cloud.controller;

import com.cloud.entity.Login;
import com.cloud.modal.LoginInput;
import com.cloud.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/platform/user")
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    public LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginInput loginInput){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        logger.info(loginInput.toString());

        return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
    }

    @GetMapping("/getLoginData")
    public ResponseEntity<List<Login>> getLoginData(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        return ResponseEntity.status(HttpStatus.OK).body(loginService.getAllLoginData());
    }


}
