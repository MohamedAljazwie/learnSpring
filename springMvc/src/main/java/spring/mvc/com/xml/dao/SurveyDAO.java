/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.dao;

import java.util.List;

import spring.mvc.com.xml.model.Survey;


public interface SurveyDAO {

    Survey getSurvey(int surevyId);

    List<Survey> getAllSurvey();

    int save(Survey survey);

    void update(Survey survey);

    void view(Survey survey);

    void delete(int surevyId);
}
