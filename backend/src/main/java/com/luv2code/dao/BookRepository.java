package com.luv2code.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
