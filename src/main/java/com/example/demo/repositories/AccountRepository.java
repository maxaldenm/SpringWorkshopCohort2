package com.example.demo.repositories;

import com.example.demo.beans.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {
    //@Query(value = "select max(rekeningnummer) from account", nativeQuery = true)
    //int lastBankNumber();

    @Query("select max(a.rekeningnummer) from Account a")
    Integer lastBankNumber();
}
