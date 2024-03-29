package com.reservation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.model.Flight;
import com.reservation.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping(value="/findFlights",method=RequestMethod.POST)
	public String findFloghts(@RequestParam("from") String from,@RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,ModelMap modelmap) {
		List<Flight> flights = flightRepository.findFlights(from,to,departureDate);
		modelmap.addAttribute("flights",flights);
		return "displayFlights";
	}
	
	@RequestMapping("admin/addFlight")
	public String showAddFlight() {
		return "addFlight";
	}
	
}
