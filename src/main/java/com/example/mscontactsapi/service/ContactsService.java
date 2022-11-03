package com.example.mscontactsapi.service;

import com.example.mscontactsapi.controller.api.Contact;

import java.util.List;

public interface ContactsService {
    public List<Contact> getContacts();
    public void persistContacts(List<Contact> contacts);
}
