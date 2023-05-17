package org.example;

import confi.JPA_config;
import entity.BookEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

       static ApplicationContext context = new AnnotationConfigApplicationContext(JPA_config.class);
    static BookRepository bookRepository =  (BookRepository) context.getBean("bookRepository");

    public static void main(String[] args) {
//        createNewBook();
        readBook();
//        update(1);
//        detele(3);
//        readBook();
    }
    public static void createNewBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("chinh");
        bookEntity.setAuthor("Roger");
        bookEntity.setCategory("IT books");
        bookEntity.setIsbn("ISIBF1219323");
        bookEntity.setNumberOfPage(234);
        bookEntity.setPrice(20.5);
        bookEntity.setPublishDate(LocalDate.parse("2016-08-25"));

        BookEntity result = bookRepository.save(bookEntity);

        if (result != null) {
            System.out.println("A new book saved successfully, book ID = " + bookEntity.getId());
        }

    }
    public static void  readBook(){
        List <BookEntity> bookEntityList = (List<BookEntity>) bookRepository.findAll();
        System.out.println(bookEntityList.size());
        for (BookEntity book: bookEntityList ) {
            System.out.println(book.toString());

        }
    }
    public static void  readBook(int bookId){
        Optional<BookEntity> bookEntityList = bookRepository.findById(bookId);
        if (bookEntityList !=null){
            System.out.println(bookEntityList.toString());
        } else {
            System.out.println("không có tài khoản id" + bookId);
        }
    }
    private static  void  update(int bookId){
        BookEntity bookEntity = bookRepository.findById(bookId).get();
        System.out.println(bookEntity.toString());
        bookEntity.setName("vien");
        bookEntity.setNumberOfPage(199);
        bookEntity.setPrice(2000);
        bookRepository.save(bookEntity);
        System.out.println(bookEntity.toString());
    }
    private  static void detele(int bookId){
        BookEntity bookEntity = bookRepository.findById(bookId).get();
        if (bookEntity!=null){
            bookRepository.delete(bookEntity);
        } else  {
            System.out.println("không có tài khoản " + bookId);
        }
    }

}