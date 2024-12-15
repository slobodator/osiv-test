package com.slobodator.osivtest.repository;

import com.slobodator.osivtest.OsivTestApplicationTests;
import com.slobodator.osivtest.entity.Parent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ParentRepositoryTest extends OsivTestApplicationTests {
    @Autowired
    private ParentRepository parentRepository;

    @BeforeEach
    void init() {
        parentRepository.save(
                new Parent("parent")
                        .addChild("child1")
                        .addChild("child2")
        );
    }

    @Test
    void load() {
        var parents = parentRepository.findAll();
        var parent = parents.getFirst();
        System.out.println(parent);
        System.out.println(parent.getChildren());
    }
}