package com.slobodator.osivtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(onlyExplicitlyIncluded = true)
@Getter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ToString.Include
    private Long id;

    @ToString.Include
    private String name;

    @ManyToOne
    @JsonIgnore
    private Parent parent;

    public Child(String name, Parent parent) {
        this.name = name;
        this.parent = parent;
    }
}
