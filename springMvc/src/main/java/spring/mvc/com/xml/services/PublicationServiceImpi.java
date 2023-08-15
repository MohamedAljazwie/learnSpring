/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.services;


import java.util.List;

import spring.mvc.com.xml.dao.PublicationDao;
import spring.mvc.com.xml.model.Publication;

/**
 *
 * @author MohamedSayed
 */
public class PublicationServiceImpi implements PublicationService{
private PublicationDao publicationDao;

    public PublicationDao getPublicationDao() {
        return publicationDao;
    }

    public void setPublicationDao(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }


    @Override
    public void addPublication(Publication publication) {
publicationDao.addPublication(publication);;
    }

    @Override
    public List<Publication> getPublications() {
return publicationDao.getPublications();
    }

    @Override
    public Publication getPublication(int pubId) {
return publicationDao.getPublication(pubId);
    }

    @Override
    public void deletePublication(int pubId) {
publicationDao.deletePublication(pubId);
    }

    @Override
    public Publication getPublication(Publication publication) {
return publicationDao.getPublication(publication);
    }

    @Override
    public void deletePublication(Publication publication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
