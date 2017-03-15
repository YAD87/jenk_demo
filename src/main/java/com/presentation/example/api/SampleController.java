package com.presentation.example.api;

import com.presentation.example.entities.Gender;
import com.presentation.example.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping(value = "/")
    @ResponseBody
    User homePage() {
        return User.newBuilder()
                .setName("Test")
                .setLastName("LastName")
                .setAge(22L)
                .setGender(Gender.MALE)
                .build();
    }

    @RequestMapping(value = "/other")
    @ResponseBody
    String otherPage() {
        return "Other page---11--";
    }



    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }

}
