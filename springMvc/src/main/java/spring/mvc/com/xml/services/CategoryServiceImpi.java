/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.services;

import spring.mvc.com.xml.dao.CategoryDao;
import spring.mvc.com.xml.model.*;

import java.util.List;

/**
 *
 * @author MohamedSayed
 */
public class CategoryServiceImpi implements CategoryService{
private CategoryDao categoryDao;

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public void addCategory(Category category) {
categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getCategories() {
return  categoryDao.getCategories();
    }

    @Override
    public Category getCategory(int categoryId) {
return categoryDao.getCategory(categoryId);
    }

    @Override
    public Category getCategory(Category category) {
return categoryDao.getCategory(category);
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
