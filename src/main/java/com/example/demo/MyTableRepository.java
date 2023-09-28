package com.example.demo;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyTableRepository extends JpaRepository<MyTestTable, String> {

    @Query("Select T from MyTestTable T where T.version = :version")
    List<MyTestTable> findResult(@Param("version") int version);
}
