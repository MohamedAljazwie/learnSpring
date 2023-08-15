/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.controller.annotations;

import spring.mvc.com.xml.model.*;
import spring.mvc.com.xml.services.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicationController {
 

 private PublicationService publicationService;
 
 
 private CategoryService categoryService;

    public PublicationService getPublicationService() {
        return publicationService;
    }

    public void setPublicationService(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
 
 
 
 
 @RequestMapping(value = "/savePublication", method = RequestMethod.POST)
 public ModelAndView saveEmployee(@ModelAttribute("command") Publication publication, 
   BindingResult result) {
  publicationService.addPublication(publication);
  return new ModelAndView("redirect:/addPublication.html");
 }
 
 @RequestMapping(value = "/addPublication", method = RequestMethod.GET)
 public ModelAndView addPublication(@ModelAttribute("command")  Publication publication,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("publications",  publicationService.getPublications());
  model.put("categories",  categoryService.getCategories());
  return new ModelAndView("addPublication", model);
 }
 
 @RequestMapping(value = "/deletePublication", method = RequestMethod.GET)
 public ModelAndView deletePublication(@ModelAttribute("command")  Publication publication,
   BindingResult result) {
  publicationService.deletePublication(publication);
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("publications",  publicationService.getPublications());
  model.put("categories",  categoryService.getCategories());
  return new ModelAndView("addPublication", model);
 }
 
 @RequestMapping(value = "/editPublication", method = RequestMethod.GET)
 public ModelAndView editPublication(@ModelAttribute("command")  Publication publication,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("publication",  publicationService.getPublication(publication));
  model.put("publications",  publicationService.getPublications());
  model.put("categories",  categoryService.getCategories());
  return new ModelAndView("addPublication", model);
 }
 
 @RequestMapping(value="/publications", method = RequestMethod.GET)
 public List<Publication> getPublications() {
  return publicationService.getPublications();
 }
}
