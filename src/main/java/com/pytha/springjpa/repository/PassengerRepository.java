package com.pytha.springjpa.repository;

import com.pytha.springjpa.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
