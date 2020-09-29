package com.tameka.flightreservation.service;

import com.tameka.flightreservation.dto.ReservationRequest;
import com.tameka.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation BookFlight(ReservationRequest request);
		
		
	
	

}
