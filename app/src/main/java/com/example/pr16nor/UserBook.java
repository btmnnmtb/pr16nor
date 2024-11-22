package com.example.pr16nor;

import java.io.Serializable;

public class UserBook implements Serializable { // Реализуем Serializable
    private String id;
    private String nameAuthor;
    private String nameBook;
    private String emailAuthor;
    private String numberPhone;

    public UserBook(String id , String nameAuthor, String nameBook, String emailAuthor, String phone) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.nameBook = nameBook;
        this.emailAuthor = emailAuthor;
        this.numberPhone = phone;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getId() {
        return id;
    }

    public void setNameAuthor(String author) {
    }

    public void setNameBook(String book) {
    }

    public void setEmailAuthor(String email) {
    }

    public void setNumberPhone(String phone) {

    }
}