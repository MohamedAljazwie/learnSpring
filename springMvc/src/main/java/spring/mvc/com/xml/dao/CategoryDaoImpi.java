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

import spring.mvc.com.xml.model.Category;


/**
 *
 * @author MohamedSayed
 */
public class CategoryDaoImpi extends HibernateDaoSupport implements CategoryDao{

    @Override
    public void addCategory(Category category) {
        Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(category);
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
    public List<Category> getCategories() {

         Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            
            return session.createQuery(" from Category").list();
            
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
    public Category getCategory(int categoryId) {
   Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            Filter filter= session.enableFilter("customCategories");
            filter.setParameter("cat_id", categoryId);
            List<Category> categorys= session.createQuery(" from Category").list();
            return categorys.get(0);
        }catch(HibernateException e)
        {
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new Category();
    }

    @Override
    public Category getCategory(Category category) {
  Session session=getHibernateTemplate().getSessionFactory().openSession();
        try{
            Filter filter= session.enableFilter("customCategories");
            filter.setParameter("cat_id", category.getCategoryId());
            List<Category> categorys= session.createQuery(" from Category").list();
            return categorys.get(0);
        }catch(HibernateException e)
        {
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new Category();
    }

    @Override
    public void deleteCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
