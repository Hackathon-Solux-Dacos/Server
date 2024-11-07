package com.example.SoluxDacos.domain.book;

import jakarta.persistence.*;

@Entity
public class UserResponse {
    @Id
    private Long id;
    private String userReaction;  // 좋아요 or 싫어요
    private String title;  // 책 제목
    private String content;  // 책 내용
    private String category;  // 책 분류
    private int length;  // 책 분량
    private int passTime;  // 패스까지의 시간 정보

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserReaction() {
        return userReaction;  // userReaction 반환
    }

    public void setUserReaction(String userReaction) {
        this.userReaction = userReaction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPassTime() {
        return passTime;
    }

    public void setPassTime(int passTime) {
        this.passTime = passTime;
    }
}
