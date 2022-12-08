package com.nest.libraryapp_backend.dao;

import com.nest.libraryapp_backend.model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksDao extends CrudRepository<Books,Integer> {

    @Query(value = "SELECT `id`, `description`, `image`, `price`, `title` FROM `books` WHERE `title`LIKE %:title%",nativeQuery = true)
    List<Books> searchBooks(@Param("title")String title);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `books` WHERE `id`=:id",nativeQuery = true)
    void deleteBook(@Param("id")Integer id);
}
