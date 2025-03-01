package com.bridgelabz.address_book_app_development.controller;

import com.bridgelabz.address_book_app_development.dto.AddressDTO;
import com.bridgelabz.address_book_app_development.model.AddressModel;
import com.bridgelabz.address_book_app_development.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin(origins = "*")
public class AddressController {
    @Autowired
    private AddressService contactService;

    @PostMapping("/post")
    public ResponseEntity<AddressModel> addContact(@Valid @RequestBody AddressDTO contactDTO) {
        AddressModel savedContact = contactService.addContact(contactDTO);
        return ResponseEntity.ok(savedContact);
    }
}
