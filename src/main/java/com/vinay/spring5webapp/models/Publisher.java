package com.vinay.spring5webapp.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Publisher implements Serializable {

    private static final long serialVersionUID = 3801281035462579847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Book book;

    public Publisher() {
    }

    public Publisher(String name,String address) {
        this.name = name;
        this.address = address;
    }

    public Publisher(String name, String address ,Book book) {
        this.name = name;
        this.address = address;
        this.book = book;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
