package com.tameka.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tameka.flightreservation.entities.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
