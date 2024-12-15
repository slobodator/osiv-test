package com.slobodator.osivtest.repository;

import com.slobodator.osivtest.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
