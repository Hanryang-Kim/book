package com.example.demo.book.service;

import com.example.demo.book.entity.Book;
import com.example.demo.book.model.BookDto;
import com.example.demo.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 1. 책 등록
    public void register(BookDto.Register dto) {
        Book book = dto.toEntity();
        bookRepository.save(book);
    }

    // 2. 책 단건 조회
    public BookDto.ARes read(Integer idx) {
        Optional<Book> result = bookRepository.findById(idx);
        return result.map(BookDto.ARes::from)
                .orElseThrow(() -> new RuntimeException("책이 존재하지 않습니다."));
    }

    // 3. 전체 책 리스트 조회
    public List<BookDto.ARes> list() {
        List<Book> result = bookRepository.findAll();
        return result.stream().map(BookDto.ARes::from).toList();
    }
}
