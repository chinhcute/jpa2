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
        orderBy();
    }
    public static void createNewBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("tran cong chinh");
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
     private static void lessThan(){
       List<BookEntity>  bookEntityList =  bookRepository.findByPublishDateLessThan(LocalDate.parse("2016-08-26"));
//        for (BookEntity book : bookEntityList){
//            System.out.println(book.toString());
//        }
         for (int i = 0; i < bookEntityList.size(); i++) {
             System.out.println(bookEntityList.get(i).toString());
         }
    }
    private static void greaterThan(){
        List<BookEntity> bookEntityList = bookRepository.findByPublishDateGreaterThan(LocalDate.parse("2016-08-24"));
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void dataStart(){
        List<BookEntity> bookEntityList = bookRepository.findByPublishDateAfter(LocalDate.parse("2016-08-24"));
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void dataBefore(){
        List<BookEntity> bookEntityList = bookRepository.findByPublishDateBefore(LocalDate.parse("2016-08-24"));
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void nul(){
        List<BookEntity> bookEntityList = bookRepository.findByPublishDateIsNull();
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void notNul(){
        List<BookEntity> bookEntityList = bookRepository.findByPublishDateNotNull();
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void like(){
        List<BookEntity> bookEntityList = bookRepository.findByNameLike("chinh");
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void like_start(){
        List<BookEntity> bookEntityList = bookRepository.findByNameStartingWith("chinh");
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void like_end(){
        List<BookEntity> bookEntityList = bookRepository.findByNameEndingWith("chinh");
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void like_containing(){
        List<BookEntity> bookEntityList = bookRepository.findByNameContaining("chinh");
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
    private static void orderBy(){
        List<BookEntity> bookEntityList = bookRepository.findByNameOrderByIdDesc("chinh");
        for (BookEntity book : bookEntityList){
            System.out.println(book.toString());
        }
    }
}