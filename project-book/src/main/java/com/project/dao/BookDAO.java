package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Book;

@Repository
@Transactional
public interface BookDAO extends JpaRepository<Book, Integer>{

}
