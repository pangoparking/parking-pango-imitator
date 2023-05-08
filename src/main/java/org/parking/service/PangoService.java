package org.parking.service;

import java.time.LocalTime;


public interface PangoService {
LocalTime checkIfPaid(Long carID);
}
