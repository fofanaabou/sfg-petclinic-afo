package com.example.sfgpetclinicafo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.example", "com.example",})
@EnableJpaRepositories("com.example.sfgpetclinic.repositories")
@EntityScan("com.example.sfgpetclinic.model")
@SpringBootApplication
public class SfgPetclinicAfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgPetclinicAfoApplication.class, args);
    }

}
