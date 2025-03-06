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
    private AddressService addressService;

    // Create a new contact
    @PostMapping("/add")
    public ResponseEntity<AddressModel> addContact(@Valid @RequestBody AddressDTO contactDTO) {
        return ResponseEntity.ok(addressService.addContact(contactDTO));
    }

    // Get all contacts
    @GetMapping("/all")
    public ResponseEntity<List<AddressModel>> getAllContacts() {
        return ResponseEntity.ok(addressService.getAllContacts());
    }

    // Get contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressModel>> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getContactById(id));
    }

    // Update contact by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressModel> updateContact(@PathVariable Long id, @Valid @RequestBody AddressDTO contactDTO) {
        return ResponseEntity.ok(addressService.updateContact(id, contactDTO));
    }

    // Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        addressService.deleteContact(id);
        return ResponseEntity.ok("Contact deleted successfully.");
    }
}
