package com.slobodator.osivtest.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(onlyExplicitlyIncluded = true)
@Getter
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ToString.Include
    private Long id;

    @ToString.Include
    private String name;

    @SuppressWarnings("FieldMayBeFinal")
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children = new ArrayList<>();

    public Parent(String name) {
        this.name = name;
    }

    public Parent addChild(String childName) {
        children.add(
                new Child(childName, this)
        );
        return this;
    }
}
