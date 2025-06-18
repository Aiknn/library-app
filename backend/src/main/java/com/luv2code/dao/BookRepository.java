package com.luv2code.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);
}
