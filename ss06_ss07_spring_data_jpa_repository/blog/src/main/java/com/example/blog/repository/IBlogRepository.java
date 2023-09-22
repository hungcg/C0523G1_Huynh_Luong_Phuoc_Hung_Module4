package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAllByTitleContaining(Pageable pageable,String title);

    @Query(value = "select * from blog where title like :title", nativeQuery = true)
    List<Blog> searchByTitle(@Param("title") String title);
}
