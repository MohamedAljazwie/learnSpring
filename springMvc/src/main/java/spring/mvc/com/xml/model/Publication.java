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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "Publications")
@FilterDef(name = "customPublications", parameters = {
    @ParamDef(name = "pub_Id", type = "java.lang.Integer")})
    @Filter(name = "customPublications", condition = "pubId = :pub_Id ")

public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
  @SequenceGenerator(name = "Publicationseq", initialValue = 100, allocationSize = 1, sequenceName = "Publicationseqid")
    @GeneratedValue(generator = "Publicationseq", strategy = GenerationType.SEQUENCE)
   
    @Column(name = "pubId")
    private Integer pubId;

    @Column(name = "Title")
    private String pubTitle;

    @OneToOne
    @JoinColumn(name = "categoryId" ,referencedColumnName ="categoryId" )
    @BatchSize(size = 100)
    private Category category;

    @Column(name = "content")
    private String pubContent;

    public Integer getPubId() {
        return pubId;
    }

    public void setPubId(Integer pubId) {
        this.pubId = pubId;
    }

    public String getPubTitle() {
        return pubTitle;
    }

    public void setPubTitle(String pubTitle) {
        this.pubTitle = pubTitle;
    }

    public String getPubContent() {
        return pubContent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPubContent(String pubContent) {
        this.pubContent = pubContent;
    }
}
