package com.example.SoluxDacos.repository.book;

import com.example.SoluxDacos.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
