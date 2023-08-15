/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.model;

/**
 *
 * @author MohamedSayed
 */
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "questions")

public class Question {

    @Id
    @SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")

    private int QUESTION_ID;
    @Column
    private String QUESTION;

    @Transient
    private List<String> answers;

    @ManyToOne
    @JoinColumn(name = "SURVEY_ID")
    private Survey survey;

    public Question() {
    }

    public Question(int QUESTION_ID, String QUESTION, Survey survey) {
        super();
        this.QUESTION_ID = QUESTION_ID;
        this.QUESTION = QUESTION;
        this.survey = survey;
    }


    public int getQUESTION_ID() {
        return QUESTION_ID;
    }

    public void setQUESTION_ID(int QUESTION_ID) {
        this.QUESTION_ID = QUESTION_ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

}
