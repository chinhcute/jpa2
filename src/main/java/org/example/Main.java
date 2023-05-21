package org.example;

import confi.JPA_config;
import entity.BookDetailsEntity;
import entity.BookEntity;
import entity.CategoryEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;
import repository.CategoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static ApplicationContext context = new AnnotationConfigApplicationContext(JPA_config.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository");

    public static void main(String[] args) {
//     createNewBook();
//        readBook();
//        update(1);
//        detele(3);
//        readBook();
//        lessThan();
//        greaterThan();
//        dataStart();
//        dataBefore();
//        nul();
//        notNul();
//        like();
//        like_start();
//        like_end();
//        like_containing();
//        orderBy();
        //createNewBookEntryWithNewCategory();
//        createNewBookEntryWithNewCategory();
//        createNewBookEntry();
        getJon(1);
    }

    //    public static BookEntity createNewBook() {
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setName("tran cong chinh");
//        bookEntity.setAuthor("Roger");
//        bookEntity.setCategory("IT books");
//        bookEntity.setIsbn("ISIBF1219323");
//        bookEntity.setNumberOfPage(234);
//        bookEntity.setPrice(20.5);
//        bookEntity.setPublishDate(LocalDate.parse("2016-08-25"));
//
//        BookEntity result = bookRepository.save(bookEntity);
//
//        if (result != null) {
//            System.out.println("A new book saved successfully, book ID = " + bookEntity.getId());
//        }
//
//        return bookEntity;
//    }
    public static BookEntity createNewBook() {
        BookDetailsEntity bookDetails = new BookDetailsEntity();
        bookDetails.setIsbn("chinh");
        bookDetails.setNumber(23);
        bookDetails.setPrice(11.2);
        bookDetails.setPublishDate(LocalDate.now());
        BookEntity book = new BookEntity();
        book.setName("java a -> z");
        book.setAuthor("roger");
        book.setBookDetails(bookDetails);
        bookDetails.setBook(book);
        return book;

    }

    public static void createNewBookEntry() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1);
        BookEntity book = createNewBook();
        book.setCategory(categoryEntity);
        bookRepository.save(book);

    }

    public static void createNewBookEntryWithNewCategory() {
        CategoryEntity categoryEntity = createNewCategory();
        categoryRepository.save(categoryEntity);
        BookEntity book = createNewBook();
        book.setCategory(categoryEntity);
        bookRepository.save(book);
    }

    public static CategoryEntity createNewCategory() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("IT");
        categoryEntity.setDescription("It book");
        return categoryEntity;
    }
    public static void getJon(int id){
       List<BookEntity>  bookEntity = (List<BookEntity>) bookRepository.getJon(id);
        for(BookEntity book : bookEntity){

            CategoryEntity category = book.getCategory();
            System.out.println(book.toString() + " - "+ category.getName() + " - "+ category.getDescription());
        }
    }

//    public static void readBook() {
//        List<BookEntity> bookEntityList = (List<BookEntity>) bookRepository.findAll();
//        System.out.println(bookEntityList.size());
//        for (BookEntity book : bookEntityList) {
//            System.out.println(book.toString());
//
//        }
//    }
//
//    public static void readBook(int bookId) {
//        Optional<BookEntity> bookEntityList = bookRepository.findById(bookId);
//        if (bookEntityList != null) {
//            System.out.println(bookEntityList.toString());
//        } else {
//            System.out.println("không có tài khoản id" + bookId);
//        }
//    }
//
//    private static void update(int bookId) {
//        BookEntity bookEntity = bookRepository.findById(bookId).get();
//        System.out.println(bookEntity.toString());
//        bookEntity.setName("vien");
//
//        bookRepository.save(bookEntity);
//        System.out.println(bookEntity.toString());
//    }
//
//    private static void detele(int bookId) {
//        BookEntity bookEntity = bookRepository.findById(bookId).get();
//        if (bookEntity != null) {
//            bookRepository.delete(bookEntity);
//        } else {
//            System.out.println("không có tài khoản " + bookId);
//        }
//    }

}