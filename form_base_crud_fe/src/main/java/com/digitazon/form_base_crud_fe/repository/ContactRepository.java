package com.digitazon.form_base_crud_fe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.form_base_crud_fe.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    public Contact findByUsername(String userName);
}
