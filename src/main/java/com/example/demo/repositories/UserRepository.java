package com.example.demo.repositories;

import com.example.demo.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u where u.bsn = :bsn") //JPQL syntax vs SQL (native query)
    User searchByBsn(@Param("bsn") String bsn);
}
