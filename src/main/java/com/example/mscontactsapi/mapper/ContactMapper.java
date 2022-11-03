package com.example.mscontactsapi.mapper;

import com.example.mscontactsapi.controller.api.Contact;
import com.example.mscontactsapi.repository.model.ContactDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDTO toContactDTO(Contact contact);
    Contact toContact(ContactDTO contactDTO);
    List<Contact> toContact(List<ContactDTO> contactDTO);
    List<ContactDTO> toContactDTO(List<Contact> contacts);
}
