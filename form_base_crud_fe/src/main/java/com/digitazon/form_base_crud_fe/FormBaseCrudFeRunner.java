package com.digitazon.form_base_crud_fe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import com.digitazon.form_base_crud_fe.model.Contact;
import com.digitazon.form_base_crud_fe.service.ContactService;

@Component
public class FormBaseCrudFeRunner implements CommandLineRunner {

    @Autowired
    ContactService contactService;

    @Override
    public void run(String... args) throws Exception {

        Contact c1 = new Contact("Julliver", "giulia.cassano@gmail.com");
        Contact c2 = new Contact("Armandeiro", "alex.armari@libero.it");

        contactService.saveContact(c1);
        contactService.saveContact(c2);

    }

}
