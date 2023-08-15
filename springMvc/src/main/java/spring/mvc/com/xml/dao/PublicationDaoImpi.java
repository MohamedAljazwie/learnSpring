/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import spring.mvc.com.xml.model.*;

/**
 *
 * @author MohamedSayed
 */
public class PublicationDaoImpi extends HibernateDaoSupport implements PublicationDao{

    @Override
    public void addPublication(Publication publication) {
       Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(publication);
            session.getTransaction().commit();
            
        }catch(HibernateException e)
        {
        session.getTransaction().rollback();
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Publication> getPublications() {
       
         Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            
            return session.createQuery(" from Publication").list();
            
        }catch(HibernateException e)
        {
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    @Override
    public Publication getPublication(int pubId) {
      Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            Filter filter= session.enableFilter("customPublications");
            filter.setParameter("pub_Id", pubId);
            List<Publication> publications= session.createQuery(" from Publication").list();
            return publications.get(0);
        }catch(HibernateException e)
        {
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new Publication();
    }

    @Override
    public void deletePublication(int pubId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publication getPublication(Publication publication) {
       Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            Filter filter= session.enableFilter("customPublications");
            filter.setParameter("pub_Id", publication.getPubId());
            List<Publication> publications= session.createQuery(" from Publication").list();
            return publications.get(0);
        }catch(HibernateException e)
        {
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new Publication();
    }

    @Override
    public void deletePublication(Publication publication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
