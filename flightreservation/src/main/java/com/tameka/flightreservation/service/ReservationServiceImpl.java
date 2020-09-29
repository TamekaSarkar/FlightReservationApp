package com.tameka.flightreservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tameka.flightreservation.controllers.UserController;
import com.tameka.flightreservation.dto.ReservationRequest;
import com.tameka.flightreservation.entities.Flight;
import com.tameka.flightreservation.entities.Passenger;
import com.tameka.flightreservation.entities.Reservation;
import com.tameka.flightreservation.repos.FlightRepository;
import com.tameka.flightreservation.repos.PassengerRepository;
import com.tameka.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private FlightRepository repoflight;
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	
	private  static final Logger LOGGER = LoggerFactory.getLogger( ReservationServiceImpl.class);

	@Override
	public Reservation BookFlight(ReservationRequest request) {
		Long flightId = request.getFlightId();
		Flight flight = repoflight.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmai());
		Passenger savedPassenger = passengerRepo.save(passenger);
		
		LOGGER.info("saving the passenger"+passenger);
		
		Reservation reservation = new Reservation();
		reservation.setPassenger(savedPassenger);
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepo.save(reservation);
		
		
		
		return savedReservation;
	}

}
