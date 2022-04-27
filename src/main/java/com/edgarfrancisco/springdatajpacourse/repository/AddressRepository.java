package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
