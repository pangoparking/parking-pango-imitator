package org.parking.service;

import java.time.LocalTime;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PangoServiceImpl implements PangoService {

	@Override
	public LocalTime checkIfPaid(Long carId) {
		LocalTime start = LocalTime.now().minusHours(2);
		LocalTime end =LocalTime.now().plusHours(2);
	return generateTime(start,end);
	}

	private  LocalTime generateTime(LocalTime start, LocalTime end) {
		
		Random random = new Random();
		 double probability = random.nextDouble(); 
		 
		    if (probability < 0.85) { 
		        long startSeconds = start.toSecondOfDay();
		        long endSeconds = end.toSecondOfDay();
		        long randomSeconds = startSeconds + (long) (random.nextDouble() * (endSeconds - startSeconds));
		        System.err.println(LocalTime.ofSecondOfDay(randomSeconds));
		        return LocalTime.ofSecondOfDay(randomSeconds);
		    } else {		      
		        return null;
		    }
		};
	}
		
		
	
