package com.example.SoluxDacos.controller.book;

import com.example.SoluxDacos.domain.book.Book;
import com.example.SoluxDacos.domain.book.UserResponse;
import com.example.SoluxDacos.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 2. 사용자 반응에 맞는 메시지 반환 -> 후에 데이터 연결
    @PostMapping("/response")
    public String getReactionMessage(@RequestBody UserResponse userResponse) {
        return bookService.getReactionMessage(userResponse);  // 반응 메시지를 반환
    }
}
