package com.example.demo.review.model;

import com.example.demo.book.model.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ReviewDto {
    @Getter
    @NoArgsConstructor
    @Setter
    public static class Register {
        private String contents;
        private Integer score;

        public Review toEntity(Book book) {
            Review entity = Review.builder()
                    .contents(contents)
                    .score(score)
                    .book(book)
                    .build();

            return entity;
        }
    }
    public static ReviewRes from(Review entity){
        ReviewRes dto = ReviewRes.builder()
                .idx(entity.getIdx())
                .title(entity.gettitle())
                .page(entity.getpage())
                .price(entity.getprice())
                .build();
        return dto;

    }
}



