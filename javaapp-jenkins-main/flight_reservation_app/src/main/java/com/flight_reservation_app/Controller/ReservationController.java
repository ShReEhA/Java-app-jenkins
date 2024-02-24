package com.flight_reservation_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	
	
	
	@RequestMapping("/confirmReservation")   // Data transfer through  dto
	public String confirmReservation(ReservationRequest request,ModelMap model) {
		Reservation reservationId = reservationService.BookFlight(request);
		model.addAttribute("reservationId", reservationId.getId());
		return "confirmReservation";
	}
	

}
