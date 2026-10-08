package com.cloudnation;

import org.springframework.data.jpa.repository.JpaRepository;

/** Spring creates all the SQL (insert, select, delete) for us. */
public interface BookRepository extends JpaRepository<Book, Long> {
}
