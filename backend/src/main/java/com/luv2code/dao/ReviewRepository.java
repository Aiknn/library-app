package com.luv2code.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

    Page<Review> findByBookId(@RequestParam("book_id") Long bookId, Pageable pageable);
}
