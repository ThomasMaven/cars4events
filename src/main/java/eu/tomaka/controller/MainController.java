package eu.tomaka.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tomek on 01.04.18.
 */
@Controller
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Page under construction...";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }
}
