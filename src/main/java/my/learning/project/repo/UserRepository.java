package my.learning.project.repo;

import my.learning.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER_BOOK (user_id, book_id) VALUES (:user_id, :book_id)", nativeQuery = true)
    void issueBookForUser(@Param("user_id") Integer user_id, @Param("book_id") Integer book_id);
}
