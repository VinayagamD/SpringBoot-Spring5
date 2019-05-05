package com.vinay.spring5webapp.repositories;

import com.vinay.spring5webapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
