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

    // 2. 사용자 반응에 맞는 책이름 반환 (5개 책에 대한 반응 -> 적합한 책 추천하는 알고리즘)
    @PostMapping("/find/my_interest")
    public List<String> getReactionMessages(@RequestBody List<UserResponse> userResponses) {
        return userResponses.stream()
                .map(bookService::getReactionMessage)  // 각 UserResponse에 대해 반응 메시지 생성
                .collect(Collectors.toList());  // 결과를 리스트로 반환
    }

}
