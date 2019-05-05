package com.vinay.spring5webapp.repositories;

import com.vinay.spring5webapp.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
