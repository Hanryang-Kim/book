package com.example.demo.book.entity;

import com.example.demo.review.model.Review; // 실제 리뷰 엔티티 import
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    private String title;

    private String page;

    private String price;

    //  (1:N 관계) "A 엔티티 하나가 여러 B 엔티티를 갖고 있고, A가 어떤 행동을 하면 B도 자동으로 처리해줘."
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList;
}
