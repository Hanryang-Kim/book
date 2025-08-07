package com.example.demo.book.model;

import com.example.demo.book.entity.Book; // ← 실제 Book 엔티티로 바꿔야 함
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BookDto {

    // 단건 조회 응답용 DTO
    @Getter
    @Builder
    public static class ARes {
        private Integer idx;
        private String title;
        private String page;
        private String price;

        // 리뷰 목록 포함하려면
        private List<ReviewDto.BRes> reviewList;  // ← 리뷰 DTO 연결
    }

    // 책 등록 요청용 DTO
    @Getter
    public static class Register {
        private String title;
        private String page;
        private String price;

        public Book toEntity() {
            return Book.builder()
                    .title(title)
                    .page(page)
                    .price(price)
                    .build();
        }
    }
}
