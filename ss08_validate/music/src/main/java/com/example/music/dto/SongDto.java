package com.example.music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SongDto implements Validator {
    private int id;
    //    @NotBlank(message = "require not empty")
//    @Pattern(regexp ="^[A-Z][a-z]*$" )
    private String name;
    @NotBlank
    @Min(1)
    @Max(800)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]$")
    private String singer;
    @NotBlank
    @Min(1)
    @Max(1000)
    @Pattern(regexp = "[a-zA-Z,]")
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
        if (("").equals(getName())) {
            errors.rejectValue("name", null, "this field cannot empty");
        } else if (!songDto.getName().matches("^[a-zA-Z0-9\\s]{1,800}$")) {
            errors.rejectValue("name", null, "this field cannot contain special character and maximum 800 characters");
        }
    }
}
