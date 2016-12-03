package com.rayeston.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Rayest on 2016/12/3 0003.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
