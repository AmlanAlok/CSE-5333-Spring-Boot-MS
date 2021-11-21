package com.cloud.service;

import com.cloud.entity.Role;
import com.cloud.entity.User;
import com.cloud.modal.LoginInput;
import com.cloud.repository.RoleRepository;
import com.cloud.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LoginService {

    private static final Logger logger = Logger.getLogger(LoginService.class.getName());

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

    public ResponseEntity<JSONObject> loginUser(LoginInput loginInput){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        try {
            logger.info("Getting user by emailId");
            User user = userRepository.findByEmailId(loginInput.getEmail());
            logger.info(user.toString());

            JSONObject loginObj = new JSONObject();

            if (Objects.equals(user.getPassword(), loginInput.getPassword())){

                Role role = roleRepository.findById(user.getRolesId()).get();
                loginObj.put("loginStatus", "success");
                loginObj.put("userId", user.getId());
                loginObj.put("role", role.getName());
            }
            else{
                loginObj.put("loginStatus", "failed");
                loginObj.put("error", "Password did not match");
            }

            loginObj.put("email", loginInput.getEmail());
            responseData.put("message","success");
            responseData.put("data", loginObj);

            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred getting user from RDS", e);
            responseData.put("message","failed");
            responseData.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }

    }
}
