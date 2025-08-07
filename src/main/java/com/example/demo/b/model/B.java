package com.example.demo.b.model;

import com.example.demo.a.model.A;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String b01;
    private String b02;

    @ManyToOne
    @JoinColumn(name = "a_idx")
    private A a;
}
