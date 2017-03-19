

package com.shortenUrl.models;

import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.URL;

/**
 *
 * @author abdalrahman.sharawy
 */
@Entity()
@DynamicInsert
@DynamicUpdate
public class UrlModel implements java.io.Serializable, Cloneable, Comparator<UrlModel>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "URL_MODEL_SEQ")
    private int id;
    
    @NotNull(message = "Url Field should not be empty")
    @Column(unique = true)
    @URL(message = "Url should be full and valid")
    private String url;
    
    @Column(unique = true,nullable = true)
    private String shortCode;
    
    @Column(columnDefinition = "int default 0",nullable = false)
    private Integer visitorsNumber;

    public Integer getVisitorsNumber() {
        return visitorsNumber;
    }

    public void setVisitorsNumber(Integer visitorsNumber) {
        this.visitorsNumber = visitorsNumber;
    }
    
    
    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    @Override
    public int compare(UrlModel o1, UrlModel o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
