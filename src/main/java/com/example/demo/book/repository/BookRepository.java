package com.example.demo.book.repository;

import com.example.demo.a.entity.A;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<A> findByA01(String a01);
}
