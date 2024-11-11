package com.example.SoluxDacos.service.book;

import com.example.SoluxDacos.domain.book.Book;
import com.example.SoluxDacos.repository.book.BookRepository;
import com.example.SoluxDacos.repository.book.UserResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserResponseRepository userResponseRepository;  // userResponseRepository 추가

    // 1. 랜덤으로 5개의 책 정보 반환
    public List<Book> getRandomBooks() {
        List<Book> books = bookRepository.findAll();

        // 책이 5개 이하일 경우 전체 리스트를 반환
        if (books.size() <= 5) {
            return books;
        }

        // 리스트를 랜덤하게 섞고, 처음 5개를 선택
        Collections.shuffle(books);
        return books.subList(0, 5);
    }

}
