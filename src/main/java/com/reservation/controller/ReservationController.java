package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.dto.ReservationRequest;
import com.reservation.model.Flight;
import com.reservation.model.Reservation;
import com.reservation.repository.FlightRepository;
import com.reservation.repository.ReservationRepository;
import com.reservation.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelmap) {
		Flight flight = flightRepository.getOne(flightId);
		modelmap.addAttribute("flight",flight);
		return "completeReservation";
		
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelmap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelmap.addAttribute("msg", "Reservation done successfully with id: "+reservation.getId());
		return "reservationConfirmation";
		
	}

}
