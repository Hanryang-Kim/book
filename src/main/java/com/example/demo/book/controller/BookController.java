package com.example.demo.book.controller;

import com.example.demo.book.dto.BookDto;
import com.example.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 1. 책 등록
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BookDto.Register dto) {
        bookService.register(dto);
        return ResponseEntity.ok("책 등록 완료");
    }

    // 2. 책 단건 조회 (리뷰 포함)
    @GetMapping("/read")
    public ResponseEntity<BookDto.ARes> read(@RequestParam Integer idx) {
        BookDto.ARes result = bookService.read(idx);
        return ResponseEntity.ok(result);
    }

    // 3. 전체 책 조회 (필요하면 리뷰 포함/제외 선택 가능)
    @GetMapping("/list")
    public ResponseEntity<List<BookDto.ARes>> list() {
        List<BookDto.ARes> result = bookService.list();
        return ResponseEntity.ok(result);
    }
}
