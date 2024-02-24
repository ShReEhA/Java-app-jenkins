package com.flight_reservation_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
