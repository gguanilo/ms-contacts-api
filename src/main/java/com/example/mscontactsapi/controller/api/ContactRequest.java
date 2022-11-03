package com.example.mscontactsapi.controller.api;

import lombok.Data;

import java.util.List;

@Data
public class ContactRequest {
    private List<Contact> contacts;
}
