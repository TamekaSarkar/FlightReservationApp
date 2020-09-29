package com.tameka.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tameka.flightreservation.dto.ReservationRequest;
import com.tameka.flightreservation.entities.Flight;
import com.tameka.flightreservation.entities.Reservation;
import com.tameka.flightreservation.repos.FlightRepository;
import com.tameka.flightreservation.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository flightrepository;
	@Autowired
	private ReservationService service;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Flight flight = flightrepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "login/completeReservation";
	}
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String CompleteReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = service.BookFlight(request);
		modelMap.addAttribute("msg", "Reservation created Successfully" + reservation.getId());
		
		return "login/reservationConfirmation";
	}

}
