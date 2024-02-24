package com.flight_reservation_app.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.Repository.FlightRepository;
import com.flight_reservation_app.entity.Flight;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo; //predefined methods to flightRepo (it has In-Build method)
	
	@RequestMapping("/findFlights")
	public String findFlights (@RequestParam("from")String from, @RequestParam("to")String to, @RequestParam("departureDate")@DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap model) {
		List<Flight> findflights = flightRepo.findflights(from,to,departureDate);
		model.addAttribute("findFlights", findflights);
		return "displayFlights";
	}
	
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")long flightId, ModelMap model) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		model.addAttribute("flight", flight);
		return "showReservation";
	}
	
	
	
	
	
	
	
	
	
	

}
