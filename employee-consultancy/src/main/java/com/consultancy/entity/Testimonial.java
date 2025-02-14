package com.consultancy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testimonialId;
    private String title;
    private String designation;
    @Column(length = 1000)
    private String description;
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @JsonIgnore
    private String image;
    
    public Testimonial() {
    }
    
    public Testimonial(Long testimonialId, String title, String designation, String description, String image) {
        this.testimonialId = testimonialId;
        this.title = title;
        this.designation = designation;
        this.description = description;
        this.image = image;
    }
    
    public Long getTestimonialId() {
        return testimonialId;
    }
    
    public void setTestimonialId(Long testimonialId) {
        this.testimonialId = testimonialId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString() {
        return "Testimonial{" +
                "testimonialId=" + testimonialId +
                ", title='" + title + '\'' +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
