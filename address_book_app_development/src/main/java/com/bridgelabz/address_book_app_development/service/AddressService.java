package com.bridgelabz.address_book_app_development.service;

import com.bridgelabz.address_book_app_development.dto.AddressDTO;
import com.bridgelabz.address_book_app_development.model.AddressModel;
import com.bridgelabz.address_book_app_development.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    // Add a new contact
    public AddressModel addContact(AddressDTO contactDTO) {
        AddressModel contact = AddressModel.builder()
                .name(contactDTO.getName())
                .phone(contactDTO.getPhone())
                .email(contactDTO.getEmail())
                .build();
        return addressRepository.save(contact);
    }

    // Get all contacts
    public List<AddressModel> getAllContacts() {
        return addressRepository.findAll();
    }

    // Get contact by ID
    public Optional<AddressModel> getContactById(Long id) {
        return addressRepository.findById(id);
    }

    // Update contact by ID
    public AddressModel updateContact(Long id, AddressDTO contactDTO) {
        AddressModel contact = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found!"));
        contact.setName(contactDTO.getName());
        contact.setPhone(contactDTO.getPhone());
        contact.setEmail(contactDTO.getEmail());
        return addressRepository.save(contact);
    }

    // Delete contact by ID
    public void deleteContact(Long id) {
        addressRepository.deleteById(id);
    }
}
