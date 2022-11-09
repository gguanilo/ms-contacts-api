package com.example.mscontactsapi.service.impl;

import com.example.mscontactsapi.controller.api.Contact;
import com.example.mscontactsapi.mapper.ContactMapper;
import com.example.mscontactsapi.repository.ContactRepository;
import com.example.mscontactsapi.repository.model.ContactDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ContactsServiceImplTest {
    @Mock
    private ContactRepository contactRepository;
    @Mock
    private ContactMapper contactMapper;
    @InjectMocks
    private ContactsServiceImpl contactsServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getContacts() {
        when(contactRepository.findAll()).thenReturn(List.of(new ContactDTO(1, "John Doe", "jdoe@example.com")));
        when(contactMapper.toContact(ArgumentMatchers.<ContactDTO>anyList())).thenReturn(List.of(new Contact(1, "John Doe", "jdoe@example.com")));
        List<Contact> contacts = contactsServiceImpl.getContacts();
        assertEquals(1, contacts.size());
        verify(contactRepository, times(1)).findAll();
    }

    @Test
    void persistContacts() {
        when(contactMapper.toContactDTO(ArgumentMatchers.<Contact>anyList())).thenReturn(List.of(new ContactDTO(1, "John Doe", "jdoe@example.com")));
        contactsServiceImpl.persistContacts(List.of(new Contact(1, "John Doe", "jdoe@example.com")));
        verify(contactRepository, times(1)).saveAll(ArgumentMatchers.<ContactDTO>anyList());
    }
}

