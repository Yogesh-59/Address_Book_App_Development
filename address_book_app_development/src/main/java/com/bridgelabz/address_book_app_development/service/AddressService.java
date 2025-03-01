package com.bridgelabz.address_book_app_development.service;

import com.bridgelabz.address_book_app_development.dto.AddressDTO;
import com.bridgelabz.address_book_app_development.model.AddressModel;
import com.bridgelabz.address_book_app_development.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public AddressModel addContact(AddressDTO contactDTO) {
        AddressModel contact = AddressModel.builder()
                .name(contactDTO.getName())
                .phone(contactDTO.getPhone())
                .email(contactDTO.getEmail())
                .build();
        return addressRepository.save(contact);
    }
}
