package com.example.music.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private int id;
    private String name;
    private String singer;
    private String category;

    public SongDto(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getName().equals("")) {
            errors.rejectValue("name", null, "this field cannot empty");
        } else if (!songDto.getName().matches("^[a-zA-Z0-9\\s]{1,800}$")) {
            errors.rejectValue("name", null, "this field cannot contain special character and maximum 800 characters");
        }
        if (songDto.getSinger().equals("")) {
            errors.rejectValue("singer", null, "this field cannot empty");
        } else if (!songDto.getSinger().matches("^[a-zA-Z0-9\\s]{1,300}$")) {
            errors.rejectValue("singer", null, "this field cannot contain special character and maximum 300 characters");
        }
        if (songDto.getCategory().equals("")) {
            errors.rejectValue("category", null, "this field cannot empty");
        } else if (!songDto.getCategory().matches("[a-zA-Z,]{1,1000}")) {
            errors.rejectValue("category", null, "this field cannot contain special character and maximum 1000 characters");
        }
    }
}
