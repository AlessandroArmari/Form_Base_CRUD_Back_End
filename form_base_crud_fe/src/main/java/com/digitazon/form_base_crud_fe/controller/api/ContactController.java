package com.digitazon.form_base_crud_fe.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitazon.form_base_crud_fe.model.Contact;
import com.digitazon.form_base_crud_fe.service.ContactService;

@CrossOrigin
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Contact> getContactById(@RequestParam Long id) {
        return new ResponseEntity<>(contactService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Contact> updateContactById(@RequestBody Contact newContact, @RequestParam Long id) {
        return new ResponseEntity<>(contactService.updateContact(newContact, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteContact(@RequestParam Long id) {
        contactService.deleteById(id);
        return new ResponseEntity<>("Contact deleted!", HttpStatus.OK);
    }
}
