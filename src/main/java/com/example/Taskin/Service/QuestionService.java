package com.example.Taskin.Service;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.QuestionTag;
import com.example.Taskin.Model.dto.AnswerDTO;
import com.example.Taskin.Model.dto.CommentDTO;
import com.example.Taskin.Model.dto.QuestionDTO;
import com.example.Taskin.Repository.AnswerRepository;
import com.example.Taskin.Repository.CommentRepository;
import com.example.Taskin.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CommentRepository commentRepository;


    //Getting all the questions.
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    /*
    THIS PART WAS ADDED
     */
    public List<QuestionDTO> getAllQuestionDTO() {
        List<QuestionDTO> listDto = new ArrayList<>();
        List<Question> list = questionRepository.findAll();

        list.forEach(question -> {
            QuestionDTO dto = new QuestionDTO();
            dto.setId(question.getQuestionID());
            dto.setTitle(question.getQuestionTitle());
            dto.setDescription(question.getQuestionDescription());
            dto.setAuthor(question.getQuestionAskedFrom());
            dto.setDate(question.getQuestionAskedDate());
            dto.setAnswerCount(question.getQuestionAnswerCount());
            dto.setViewCount(question.getQuestionViewCount());
            dto.setVoteCount(question.getQuestionVoteCount());
            listDto.add(dto);
        });

        return listDto;
    }

    //  return all questions which have those tag.
    public List<Question> getAllQuestionWithTag(String tag){
        return questionRepository.findQuestionWithTags(tag);
    }

    /*
    THIS PART WAS ADDED
     */
    public List<QuestionDTO> getAllQuestionWithTagDTO(String tag) {
        List<QuestionDTO> listDto = new ArrayList<>();
        List<Question> list = questionRepository.findQuestionWithTags(tag);

        list.forEach(question -> {
            QuestionDTO dto = new QuestionDTO();
            dto.setId(question.getQuestionID());
            dto.setTitle(question.getQuestionTitle());
            dto.setDescription(question.getQuestionDescription());
            dto.setAuthor(question.getQuestionAskedFrom());
            dto.setDate(question.getQuestionAskedDate());
            dto.setAnswerCount(question.getQuestionAnswerCount());
            dto.setViewCount(question.getQuestionViewCount());
            dto.setVoteCount(question.getQuestionVoteCount());
            listDto.add(dto);
        });

        return listDto;
    }

    // Getting all information about a specific question for displaying question details on the screen
    public String getQuestionInformationWithQuestionID(Integer questionID){
        return questionRepository.getQuestionInformation(questionID);
    }

    // Adding a new question. UI should send question title, question text, tags, and question owner to the
    //backend. UI should get newly added question’s id.
    public Integer saveNewQuestion(String questionTitle, String questionDescription, String user, List<QuestionTag> questionTags) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Question question = new Question(questionTitle,questionDescription,user,date,questionTags);
        System.out.println(question);
        questionRepository.save(question);
        return question.getQuestionID();
    }

    // Adding a new answer for a question. In addition to the Question ID, UI should also send the following
    //fields to the back-end application: answer text and user. UI needs newly added answer’s id and
    //related question’s id.
    public Answer saveNewAnswerToQuestion(Integer questionID,String answerText, String user){
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Question question = questionRepository.getById(questionID);
        Answer answer = new Answer(answerText,user,date,question);
        answerRepository.save(answer);

        return answer;

    }

    /*
    THIS PART WAS ADDED
     */
    public AnswerDTO saveNewAnswerToQuestionDTO(Integer questionID, String answerText, String user) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Question question = questionRepository.getById(questionID);
        Answer answer = new Answer(answerText,user,date,question);
        answerRepository.save(answer);

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAnswerText(answerText);
        answerDTO.setUser(user);
        answerDTO.setAnswerDate(date);
        answerDTO.setQuestion(question);

        return answerDTO;
    }

    // Adding a new comment for a question. In addition to the Question ID, UI should also send the
    //following fields to the back-end application: comment text and user. UI needs newly added
    //comment’s id and related question’s id.
    public Comment saveNewCommentToQuestion(Integer questionID, String commentText, String user){
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Comment comment = new Comment(commentText,user,date, questionRepository.getById(questionID));
        commentRepository.save(comment);

        return comment;

    }

    /*
    THIS PART WAS ADDED
     */
    public CommentDTO saveNewCommentToQuestionDTO(Integer questionID, String commentText, String user){
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Question question = questionRepository.getById(questionID);
        Comment comment = new Comment(commentText,user,date, question);
        commentRepository.save(comment);

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setText(commentText);
        commentDTO.setAuthor(user);
        commentDTO.setDate(date);
        commentDTO.setQuestion(question);

        return commentDTO;

    }

    // Voting a question UI needs to display updated vote count on the screen.
    public void addVoteToAnswer(Integer questionID){
        questionRepository.increaseVoteCountByQuestionID(questionID);
    }

    // Voting a question UI needs to display updated vote count on the screen.
    public void removeVoteToAnswer(Integer questionID){
        questionRepository.decreaseVoteCountByQuestionID(questionID);
    }

}
