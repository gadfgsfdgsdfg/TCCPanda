package com.example.tcc.Modelo;

import android.provider.ContactsContract;

public class Usuario {

    private String chamar;
    private ContactsContract.CommonDataKinds.Email email;

    public String getChamar() {
        return chamar;
    }

    public ContactsContract.CommonDataKinds.Email getEmail() {
        return email;
    }

    public void setChamar(String chamar) {
        this.chamar = chamar;
    }

    public void setEmail(ContactsContract.CommonDataKinds.Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "nome=" + chamar +
                ", Email=" + email +
                '}';
    }
}