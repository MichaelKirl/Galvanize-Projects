package com.example.springcreativemode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuerystringController {

    @GetMapping("/individual-example")
    public String getIndividualParams(@RequestParam String filter) {
        return String.format("Filter is : %s", filter);
    }

}