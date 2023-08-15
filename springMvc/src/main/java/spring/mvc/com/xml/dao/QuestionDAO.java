/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.dao;

import java.util.List;

import spring.mvc.com.xml.model.Question;


/**
 *
 * @author MohamedSayed
 */
public interface QuestionDAO {

    Question getQuestion(int questionID);

    List<Question> getAllQuestion();

    int save(Question question);

    void update(Question question);

    void view(Question question);

    void delete(int Question_ID);
}
