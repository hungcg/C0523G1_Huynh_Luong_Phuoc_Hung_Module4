package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String kolName;

    private String kolDescription;
    private String image;


    public Blog() {

    }

    public Blog(int id, String title, String content, String kolName, String kolDescription, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.kolName = kolName;
        this.kolDescription = kolDescription;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKolName() {
        return kolName;
    }

    public void setKolName(String kolName) {
        this.kolName = kolName;
    }

    public String getKolDescription() {
        return kolDescription;
    }

    public void setKolDescription(String kolDescription) {
        this.kolDescription = kolDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
