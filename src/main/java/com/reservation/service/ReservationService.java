package com.reservation.service;

import com.reservation.dto.ReservationRequest;
import com.reservation.model.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
	
}
