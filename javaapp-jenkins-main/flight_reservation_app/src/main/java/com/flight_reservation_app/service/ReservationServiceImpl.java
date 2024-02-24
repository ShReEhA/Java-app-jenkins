package com.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation_app.Repository.FlightRepository;
import com.flight_reservation_app.Repository.PassengerRepository;
import com.flight_reservation_app.Repository.ReservationRepository;
import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Flight;
import com.flight_reservation_app.entity.Passenger;
import com.flight_reservation_app.entity.Reservation;

@Service //service layer of app, if don't use then its ordinary class
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	
	@Autowired
	private ReservationRepository ReservationRepo;

	@Override
	public Reservation BookFlight(ReservationRequest request) {
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		ReservationRepo.save(reservation);
		
		return reservation;
		
	}
	
	
	

}
