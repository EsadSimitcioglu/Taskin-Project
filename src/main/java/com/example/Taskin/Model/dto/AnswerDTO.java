package com.example.Taskin.Model.dto;

import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.Users;

import java.sql.Date;
import java.util.List;

public class AnswerDTO {
    protected Integer id;
    protected String answerText;
    protected Integer voteCount;
    protected Date answerDate;
    protected Users user;
    protected Question question;
    protected List<Comment> answerComments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public List<Comment> getAnswerComments() {
        return answerComments;
    }

    public void setAnswerComments(List<Comment> answerComments) {
        this.answerComments = answerComments;
    }
}
