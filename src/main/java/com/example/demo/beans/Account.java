package com.example.demo.beans;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rekeningnummer;
    private int saldo;

    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRekeningnummer() {
        return rekeningnummer;
    }

    public void setRekeningnummer(int rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
