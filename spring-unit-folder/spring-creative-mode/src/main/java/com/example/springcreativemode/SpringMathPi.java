package com.example.springcreativemode;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringMathPi {

    @GetMapping("/math/pi")
    public String returnPiEndpoint() {
        return "3.141592653589793";
    }

}
