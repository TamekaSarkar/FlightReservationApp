package com.tameka.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tameka.flightreservation.entities.Flight;
import com.tameka.flightreservation.entities.Reservation;



public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
