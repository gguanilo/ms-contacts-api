package com.example.mscontactsapi.service.impl;

import com.example.mscontactsapi.controller.api.Contact;
import com.example.mscontactsapi.mapper.ContactMapper;
import com.example.mscontactsapi.repository.ContactRepository;
import com.example.mscontactsapi.service.ContactsService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toContact)
                .collect(toList());
    }

    @Override
    public void persistContacts(List<Contact> contacts) {
        contactRepository.saveAll(contactMapper.toContactDTO(contacts));
    }
}
