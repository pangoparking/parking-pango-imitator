package org.parking.controller;

import java.time.LocalTime;

import org.parking.service.PangoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PangoController
{
	public PangoService service;

	  public PangoController(PangoService service) {
		this.service = service;
	}

	@GetMapping("/car_check/{id_car}")
	  public  ResponseEntity<LocalTime> checkCar(@PathVariable("id_car") Long carId) {
	    	 
	    ResponseEntity<LocalTime> response = new ResponseEntity<>(service.checkIfPaid(carId), HttpStatus.OK);
	  
	  return  response;
	}
      
}
