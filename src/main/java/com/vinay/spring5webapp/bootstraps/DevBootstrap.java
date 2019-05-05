package com.vinay.spring5webapp.bootstraps;

import com.vinay.spring5webapp.models.Author;
import com.vinay.spring5webapp.models.Book;
import com.vinay.spring5webapp.models.Publisher;
import com.vinay.spring5webapp.repositories.AuthorRepository;
import com.vinay.spring5webapp.repositories.BookRepository;
import com.vinay.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }



    private void initData() {
        //        Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harpPub = new Publisher("Harper Catalina");
        Book ddd = new Book("Domain Driven Design", "1234",harpPub );
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        harpPub.setBook(ddd);
        authorRepository.save(eric);
        publisherRepository.save(harpPub);
        bookRepository.save(ddd);

        //        Eric
        Author rod = new Author("Rod", "Johnson");
        Publisher workPub = new Publisher("Work");
        Book noEJB = new Book("J2EE without EJB", "23444",workPub );
        rod.getBooks().add(noEJB);
        workPub.setBook(noEJB);
        authorRepository.save(rod);
        publisherRepository.save(workPub);
        bookRepository.save(noEJB);
    }
}
