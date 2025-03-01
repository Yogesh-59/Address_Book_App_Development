package com.bridgelabz.address_book_app_development.repository;

import com.bridgelabz.address_book_app_development.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {

}
