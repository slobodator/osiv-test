package com.slobodator.osivtest;

import com.slobodator.osivtest.entity.Parent;
import com.slobodator.osivtest.repository.ParentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OsivTestApplication {
    @Autowired
    private ParentRepository parentRepository;

    public static void main(String[] args) {
        SpringApplication.run(OsivTestApplication.class, args);
    }

    @PostConstruct
    public void init() {
        parentRepository.save(
                new Parent("parent")
                        .addChild("child1")
                        .addChild("child2")
        );
    }
}
