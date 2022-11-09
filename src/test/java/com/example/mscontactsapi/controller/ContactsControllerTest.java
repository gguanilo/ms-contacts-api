package com.example.mscontactsapi.controller;

import com.example.mscontactsapi.controller.api.Contact;
import com.example.mscontactsapi.service.ContactsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ContactsControllerTest {
    @Mock
    private ContactsService contactsService;
    @InjectMocks
    private ContactsController contactsController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contactsController).build();
    }

    @Test
    void testGetContactsFromMockMvc() throws Exception{
        when(contactsService.getContacts()).thenReturn(List.of(new Contact(1, "John Doe", "jdoe@example.com")));
        mockMvc.perform(get("/contacts")).andExpect(status().isOk()).andReturn();
    }

    @Test
    void testPersistContactsFromMockMvc() throws Exception{
        mockMvc.perform(post("/contacts").content(getContent()).contentType(APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
    }

    private static String getContent() {
        return "{\n" +
                "    \"contacts\": [\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"name\": \"Elma Herring\",\n" +
                "            \"email\": \"elmaherring@example.com\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"name\": \"Knapp Berry\",\n" +
                "            \"email\": \"knappberry@example.com\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 6,\n" +
                "            \"name\": \"Bell Burgess\",\n" +
                "            \"email\": \"bellburgess@example.com\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
