package com.example.demo.controllers;

import com.example.demo.beans.Account;
import com.example.demo.beans.User;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class OpenRekeningController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/openRekening")
    public String openRekening() {
        System.out.println("openRekening");
        return "openRekening";
    }

    @PostMapping("/openRekening")
    public String verwerkOpenRekening(@ModelAttribute("user") User user) {
        System.out.println("verwerkOpenRekening");

        //zoek user op zijn bsn.... bestaat bsn al? -> vragen mbv UserRepository
        //Optional<User> testUser = userRepository.findById(1);

        User testUser = userRepository.searchByBsn(user.getBsn());
        if (testUser == null) { //bestaat niet
            userRepository.save(user);
            Account account = new Account();
            account.setUser(user);
            account.setSaldo(0);
            //zoek in AccountRepository naar laatste uitgegeven banknummer
            // +1

            //check laatste uitgegeven banknr
            Integer lastBankNumber = accountRepository.lastBankNumber();
            if (lastBankNumber == null) lastBankNumber = 1000000;
            else lastBankNumber++;

            account.setRekeningnummer(lastBankNumber);

            //bewaar account
            accountRepository.save(account);
        } else { //bestaat wel!

        }
        return "openRekening";
    }
}
