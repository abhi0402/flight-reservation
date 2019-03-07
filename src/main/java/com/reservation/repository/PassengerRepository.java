package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
