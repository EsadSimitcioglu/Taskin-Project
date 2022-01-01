package com.example.Taskin.Model.dto;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.Users;

import java.util.Date;

public class CommentDTO {
    protected String text;
    protected Users author;
    protected Date date;
    protected Question question;
    protected Answer answer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

