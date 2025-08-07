package com.example.demo.a.repository;

import com.example.demo.a.model.A;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ARepository extends JpaRepository<A, Integer> {
    List<A> findByA01(String a01);
}
