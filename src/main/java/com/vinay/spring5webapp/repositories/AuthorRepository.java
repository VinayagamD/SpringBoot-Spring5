package com.vinay.spring5webapp.repositories;

import com.vinay.spring5webapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
