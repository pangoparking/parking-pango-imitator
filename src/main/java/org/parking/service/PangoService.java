package org.parking.service;

import java.time.LocalTime;

import org.parking.model.ParkingTime;


public interface PangoService {
ParkingTime checkIfPaid(Long carID);
}
