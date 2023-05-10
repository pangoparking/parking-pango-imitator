package org.parking.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

import org.parking.model.ParkingTime;
import org.springframework.stereotype.Service;

@Service
public class PangoServiceImpl implements PangoService {

	@Override
	public ParkingTime checkIfPaid(Long carId) {
		LocalDateTime start = LocalDateTime.now().minusHours(2);
		LocalDateTime end =LocalDateTime.now().plusHours(2);
		ParkingTime response = new ParkingTime();
		response.carID=carId;
		response.parkingEndTime=generateTime(start,end);
	return response;
	}

	private  LocalDateTime generateTime(LocalDateTime start, LocalDateTime end) {
		
		Random random = new Random();
		 double probability = random.nextDouble(); 
		 
		    if (probability < 0.85) { 
		    	   LocalDateTime startDateTime = LocalDateTime.now().minusHours(2);
		    	    LocalDateTime endDateTime = LocalDateTime.now().plusHours(2);
		    	    long startSeconds = startDateTime.toEpochSecond(ZoneOffset.UTC);
		    	    long endSeconds = endDateTime.toEpochSecond(ZoneOffset.UTC);
		    	    long randomSeconds = startSeconds + (long) (random.nextDouble() * (endSeconds - startSeconds));
		    	    LocalDateTime randomDateTime = LocalDateTime.ofEpochSecond(randomSeconds, 0, ZoneOffset.UTC);
		    	  //  System.err.println(randomDateTime);	    	   
		    return randomDateTime;
		    } else {		      
		        return null;
		    }
		};
	}
		
		
	
