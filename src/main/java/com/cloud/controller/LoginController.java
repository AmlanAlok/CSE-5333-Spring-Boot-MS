package com.cloud.controller;

import com.cloud.modal.LoginInput;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/platform/user")
@CrossOrigin(origins = "*")
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    @PostMapping("/login")
    public String login(@RequestBody LoginInput loginInput){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        logger.info(loginInput.toString());

        return "Received login info";
    }
}
