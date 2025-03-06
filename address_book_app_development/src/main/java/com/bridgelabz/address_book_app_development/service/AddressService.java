package com.bridgelabz.address_book_app_development.service;

import com.bridgelabz.address_book_app_development.dto.AddressDTO;
import com.bridgelabz.address_book_app_development.model.AddressModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressService {
    private final List<AddressModel> addressList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Add a new contact
    public AddressModel addContact(AddressDTO contactDTO) {
        AddressModel contact = AddressModel.builder()
                .id(idCounter.getAndIncrement()) // Generate unique ID
                .name(contactDTO.getName())
                .phone(contactDTO.getPhone())
                .email(contactDTO.getEmail())
                .build();
        addressList.add(contact);
        return contact;
    }

    // Get all contacts
    public List<AddressModel> getAllContacts() {
        return addressList;
    }

    // Get contact by ID
    public Optional<AddressModel> getContactById(Long id) {
        return addressList.stream().filter(contact -> contact.getId().equals(id)).findFirst();
    }

    // Update contact by ID
    public AddressModel updateContact(Long id, AddressDTO contactDTO) {
        Optional<AddressModel> existingContact = getContactById(id);
        if (existingContact.isPresent()) {
            AddressModel contact = existingContact.get();
            contact.setName(contactDTO.getName());
            contact.setPhone(contactDTO.getPhone());
            contact.setEmail(contactDTO.getEmail());
            return contact;
        } else {
            throw new RuntimeException("Contact not found!");
        }
    }

    // Delete contact by ID
    public boolean deleteContact(Long id) {
        return addressList.removeIf(contact -> contact.getId().equals(id));
    }
}
