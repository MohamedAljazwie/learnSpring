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
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "Categories")

@FilterDef(name = "customCategories", parameters = {
    @ParamDef(name = "cat_id", type = "java.lang.Integer")})
    @Filter(name = "customCategories", condition = "categoryId = :cat_id ")
public class Category implements Serializable {

    @Id
    @Column(name = "categoryId")
    @SequenceGenerator(name = "Categoryseq", initialValue = 100, allocationSize = 1, sequenceName = "Categoryseqid")
    @GeneratedValue(generator = "Categoryseq", strategy = GenerationType.SEQUENCE)
    private Integer categoryId;

    @Column(name = "categoryName")
    private String categoryName;
    
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "category" )
    @BatchSize(size = 100)
    private Publication publication;

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
    
    

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
