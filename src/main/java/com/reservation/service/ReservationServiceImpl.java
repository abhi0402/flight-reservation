package com.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ReservationRequest;
import com.reservation.model.Flight;
import com.reservation.model.Passenger;
import com.reservation.model.Reservation;
import com.reservation.repository.FlightRepository;
import com.reservation.repository.PassengerRepository;
import com.reservation.repository.ReservationRepository;
import com.reservation.util.EmailUtil;
import com.reservation.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.reservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	PdfGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make Payment if success then
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.getOne(flightId);
		
		Passenger pass = new Passenger();
		pass.setEmail(request.getPassengerEmail());
		pass.setFirstName(request.getPassengerFirstName());
		pass.setLastName(request.getPassengerLastName());
		pass.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerRepository.save(pass);
		
		Reservation res = new Reservation();
		res.setCheckedIn(false);
		res.setFlight(flight);
		res.setPassenger(savedPassenger);
		Reservation savedreservation = reservationRepository.save(res);
		String filePath = ITINERARY_DIR+savedreservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedreservation, filePath);
		emailUtil.sendItinerary(pass.getEmail(), filePath);
		return savedreservation;
	}

}
