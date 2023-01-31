package com.digitazon.form_base_crud_fe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.form_base_crud_fe.model.Contact;
import com.digitazon.form_base_crud_fe.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        Optional<Contact> contactOpt = contactRepository.findById(id);

        if (contactOpt.isPresent()) {
            return contactOpt.get();
        }

        return null;
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact newContact, Long id) {
        Contact oldContact = contactRepository.findById(id).get();

        if (oldContact == null) {
            return null;
        }

        oldContact.setUsername(newContact.getUsername());
        oldContact.setEmail(newContact.getEmail());

        return contactRepository.save(oldContact);
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

}
