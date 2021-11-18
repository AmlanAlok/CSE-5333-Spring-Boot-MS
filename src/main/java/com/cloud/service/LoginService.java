package com.cloud.service;

import com.cloud.entity.User;
import com.cloud.modal.LoginInput;
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

//    public List<Login> getAllLoginData(){
//        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
//                +" of "+this.getClass().getSimpleName());
//
//        try{
//            logger.info("Retrieving all Login records from RDS");
//            List<Login> allLoginRecords = loginRepository.findAll();
//            logger.info("Successfully retrieved -> "+allLoginRecords.size()+" Users");
//            logger.info(allLoginRecords.toString());
//            return allLoginRecords;
//        }
//        catch(Exception e){
//            logger.log(Level.SEVERE,"Exception occurred while getting all Users from RDS",e);
//            throw e;
//        }
//    }

    public ResponseEntity<JSONObject> loginUser(LoginInput loginInput){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        try {
            User user = userRepository.findByEmailId(loginInput.getEmail());
            logger.info(user.toString());

            JSONObject loginObj = new JSONObject();

            if (Objects.equals(user.getPassword(), loginInput.getPassword())){
                loginObj.put("loginStatus", "success");
                loginObj.put("userId", user.getId());
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
