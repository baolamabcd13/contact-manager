package com.rs.contactmanager.controller;

import com.rs.contactmanager.model.Contact;
import com.rs.contactmanager.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired private ContactRepository repository;

    @PostMapping
    public ResponseEntity<Contact> addContact(@Valid @RequestBody Contact contact) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(contact));
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @Valid @RequestBody Contact updatedContact) {
        return repository.findById(id)
                .map(contact -> {
                    contact.setName(updatedContact.getName());
                    contact.setPhone(updatedContact.getPhone());
                    return ResponseEntity.ok(repository.save(contact));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
