package com.example.mscontactsapi.service.impl;

import com.example.mscontactsapi.controller.api.Contact;
import com.example.mscontactsapi.mapper.ContactMapper;
import com.example.mscontactsapi.repository.ContactRepository;
import com.example.mscontactsapi.service.ContactsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactsServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Override
    public List<Contact> getContacts() {
        return contactMapper.toContact(contactRepository.findAll());
    }

    @Override
    public void persistContacts(List<Contact> contacts) {
        contactRepository.saveAll(contactMapper.toContactDTO(contacts));
    }
}
