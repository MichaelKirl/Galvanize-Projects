package com.example.springformdata;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class formController {

    @PostMapping("/math/area")
    public String AreaPost(@RequestParam Map<String, String> body) {
        if (body.get("type").equals("circle")) {
            double radius = Double.parseDouble(body.get("radius"));

            return String.format("Area of a circle with a radius of %f is %f", radius, Math.PI * (radius*radius));

        } else if (body.get("type").equals("rectangle")) {
            int width = Integer.parseInt(body.get("width"));
            int height = Integer.parseInt(body.get("height"));

            return String.format("Area of a " + width + "x" + height + " rectangle is " + width * height);
        }
        return "Invalid";
    }

}
