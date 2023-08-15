/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.dao;

import java.util.List;

import spring.mvc.com.xml.model.Category;


public interface CategoryDao {

    public void addCategory(Category category);

    public List<Category> getCategories();

    public Category getCategory(int categoryId);

    public Category getCategory(Category category);

    public void deleteCategory(int categoryId);

    public void deleteCategory(Category category);

}
