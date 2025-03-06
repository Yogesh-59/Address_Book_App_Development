package com.bridgelabz.address_book_app_development.controller;

import com.bridgelabz.address_book_app_development.dto.AddressDTO;
import com.bridgelabz.address_book_app_development.model.AddressModel;
import com.bridgelabz.address_book_app_development.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressService contactService;

    // POST - Add a new contact
    @PostMapping("/post")
    public ResponseEntity<AddressModel> addContact(@Valid @RequestBody AddressDTO contactDTO) {
        AddressModel savedContact = contactService.addContact(contactDTO);
        return ResponseEntity.ok(savedContact);
    }

    // GET - Retrieve all contacts
    @GetMapping("/getAll")
    public ResponseEntity<List<AddressModel>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    // GET - Retrieve a contact by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressModel> getContactById(@PathVariable Long id) {
        Optional<AddressModel> contact = contactService.getContactById(id);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT - Update an existing contact by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressModel> updateContact(@PathVariable Long id, @Valid @RequestBody AddressDTO contactDTO) {
        AddressModel updatedContact = contactService.updateContact(id, contactDTO);
        return updatedContact != null ? ResponseEntity.ok(updatedContact) : ResponseEntity.notFound().build();
    }

    // DELETE - Remove a contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
