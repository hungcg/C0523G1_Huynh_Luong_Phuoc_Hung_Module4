package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService service;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList() {
        List<Blog> blogList = service.showAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody BlogDto blogDto) {
        if (blogDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        service.add(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody BlogDto blogDto) {
        Blog blog = service.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            BeanUtils.copyProperties(blogDto, blog);
            service.update(blog);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Blog blog = service.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
