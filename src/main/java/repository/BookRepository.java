package repository;

import entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface  BookRepository extends CrudRepository<BookEntity, Integer> {
 //List<BookEntity> findByPublishDateLessThan(LocalDate PublishDate);
//       List<BookEntity> findByPublishDateGreaterThan(LocalDate PublishDate);
//       List<BookEntity> findByPublishDateAfter (LocalDate PublishDate);
//    List<BookEntity> findByPublishDateBefore (LocalDate PublishDate);
//    List<BookEntity> findByPublishDateIsNull ();
//    List<BookEntity> findByPublishDateNotNull ();
//    List<BookEntity> findByNameLike (String ki_tu);
//    List<BookEntity> findByNameStartingWith (String ki_tu);
//    List<BookEntity> findByNameEndingWith (String ki_tu);
//    List<BookEntity> findByNameContaining (String ki_tu);
//    List<BookEntity> findByNameOrderByIdDesc(String ki_tu);
    @Query(value = "SELECT * FROM spring_jpa_1.book as b join spring_jpa_1.category as c on b.categoryId = c.id where c.id = ?1"
    , nativeQuery = true)
    List<BookEntity> getJon (int id);

}
