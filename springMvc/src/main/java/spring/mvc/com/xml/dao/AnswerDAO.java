/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.dao;

import java.util.List;

import spring.mvc.com.xml.model.Answer;


/**
 *
 * @author MohamedSayed
 */
public interface AnswerDAO {

    Answer getAnswer(int answerID);

    List<Answer> getAllAnswer();

    int save(Answer answer);

    void update(Answer answer);

    void view(Answer answer);

    void delete(int Answer_ID);
}
