package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookDetails")
public class BookDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private  int id;
    @Column (name = "isbn")
    private String isbn;
    @Column (name = "price")
    private double price;
    @Column (name = "number")
    private int number;
    @Column(name = "publishDate")
    private LocalDate publishDate;
    @OneToOne(mappedBy =  "bookDetails")
    private BookEntity book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }


}
