package com.example.mscontactsapi.controller;

import com.example.mscontactsapi.controller.api.Contact;
import com.example.mscontactsapi.controller.api.ContactRequest;
import com.example.mscontactsapi.service.ContactsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactsService contactsService;

    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping
    public void persistContacts(@RequestBody ContactRequest contactRequest) {
        contactsService.persistContacts(contactRequest.getContacts());
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactsService.getContacts();
    }
}
