package com.example.sfgpetclinicafo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.sfgpetclinicafo", "com.example.sfgpetclinic",})
@SpringBootApplication
public class SfgPetclinicAfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgPetclinicAfoApplication.class, args);
    }

}
