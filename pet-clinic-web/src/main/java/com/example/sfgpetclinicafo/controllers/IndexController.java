package com.example.sfgpetclinicafo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @GetMapping({"", "/index", "/index.html", "/vets.html"})
    public String index(){
        return "index";
    }

    @GetMapping({"/find", "/oups"})
    public String findAny(){
        return "notImplemented";
    }
}
