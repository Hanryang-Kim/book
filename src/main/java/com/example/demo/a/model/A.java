package com.example.demo.a.model;

import com.example.demo.b.model.B;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String a01;
    private String a02;

    @OneToMany(mappedBy = "a")
    private List<B> bList;
}
