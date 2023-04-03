package com.app.hotel.roomreservationservice.client.reservation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationServiceClient {
	private final RestTemplate restTemplate;

	
	private String reservationServiceUrl="http://reservation-service";

	private final static String RESERVATION_SERVICE_URL = "/reservations";
	private final static String SLASH = "/";

	public ReservationServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Reservation> getAll(String usableDateString, Object object) {
		String url = reservationServiceUrl + RESERVATION_SERVICE_URL;
		ResponseEntity<Reservation[]> response = this.restTemplate.getForEntity(url, Reservation[].class);
		return Arrays.asList(response.getBody());
	}

	
}
