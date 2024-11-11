package com.example.SoluxDacos.controller.book;

import com.example.SoluxDacos.domain.book.Book;
import com.example.SoluxDacos.domain.book.UserResponse;
import com.example.SoluxDacos.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. 랜덤으로 5개의 책 정보 반환
    @GetMapping("/random")
    public List<Book> getRandomBooks() {
        return bookService.getRandomBooks();
    }
}
