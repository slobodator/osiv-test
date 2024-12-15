package com.slobodator.osivtest.controller;

import com.slobodator.osivtest.entity.Parent;
import com.slobodator.osivtest.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentRepository parentRepository;

    @GetMapping
    List<Parent> getParents() {
        return parentRepository
                .findAll();
    }
}
