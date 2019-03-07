package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dto.ReservationUpdateRequest;
import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepository.getOne(id);
	}
	
	@PostMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation res = reservationRepository.getOne(request.getId());
		res.setCheckedIn(request.getCheckedIn());
		res.setNumberOfBags(request.getNumberOfBags());
		return reservationRepository.save(res);
	}
}
