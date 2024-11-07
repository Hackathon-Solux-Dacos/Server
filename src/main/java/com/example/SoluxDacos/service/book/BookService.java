package com.example.SoluxDacos.service.book;

import com.example.SoluxDacos.domain.book.Book;
import com.example.SoluxDacos.domain.book.UserResponse;
import com.example.SoluxDacos.repository.book.BookRepository;
import com.example.SoluxDacos.repository.book.UserResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserResponseRepository userResponseRepository;  // userResponseRepository 추가

    // 1. 랜덤으로 5개의 책 정보 반환
    public List<Book> getRandomBooks() {
        List<Book> books = bookRepository.findAll();
        Random random = new Random();
        int fromIndex = random.nextInt(books.size());
        int toIndex = Math.min(fromIndex + 5, books.size());  // fromIndex + 5로 설정하여 toIndex를 제한
        return books.subList(fromIndex, toIndex);
    }

    // 2. 사용자 반응에 맞는 메시지 반환 -> 후에 데이터로 변경
    public String getReactionMessage(UserResponse userResponse) {
        String reactionMessage = "";

        if ("좋아요".equals(userResponse.getUserReaction())) {
            reactionMessage = "하하";
        } else if ("싫어요".equals(userResponse.getUserReaction())) {
            if (userResponse.getPassTime() <= 10) {
                reactionMessage = "에구";
            } else {
                reactionMessage = "길어";
            }
        }

        return reactionMessage;  // 메시지를 반환
    }
}
