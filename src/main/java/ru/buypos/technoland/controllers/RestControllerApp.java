package ru.buypos.technoland.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RestControllerApp {


    @GetMapping("/item")
    public String item () {
        return "Hello";
    }


}
