/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.services;

import java.util.List;

import spring.mvc.com.xml.model.*;;

/**
 *
 * @author MohamedSayed
 */
public interface PublicationService {

    public void addPublication(Publication publication);

    public List<Publication> getPublications();

    public Publication getPublication(int pubId);

    public void deletePublication(int pubId);

    public Publication getPublication(Publication publication);

    public void deletePublication(Publication publication);
}
