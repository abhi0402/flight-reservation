package com.reservation.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reservation.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Modifying
	@Transactional
	@Query(nativeQuery=true,value="Select * from flight where departure_city = :departureCity and arrival_city = :arrivalCity and date_ofdeparture = :dateOfdeparture")
	List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to,@Param("dateOfdeparture") Date departureDate);

}
