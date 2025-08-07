package com.example.demo.review.model;


import com.example.demo.book.model.Book;
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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String contents;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "book_idx")
    private Book book;
}
