//package com.cloud.service;
//
//import com.cloud.entity.Login;
//import com.cloud.repository.LoginRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//@Service
//public class LoginService {
//
//    private static final Logger logger = Logger.getLogger(LoginService.class.getName());
//
//    @Autowired
//    public LoginRepository loginRepository;
//
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
//}
