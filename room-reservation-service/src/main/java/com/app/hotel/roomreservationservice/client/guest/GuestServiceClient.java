package com.app.hotel.roomreservationservice.client.guest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service
public class GuestServiceClient {
	private final RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(GuestServiceClient.class);
	private String guestServiceUrl="http://guest-service";

	private final static String GUESTS_URL_PART = "/guests";
	private final static String SLASH = "/";

	public GuestServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}



	public List<Guest> getAll() {
		String url = guestServiceUrl + GUESTS_URL_PART;
		logger.info("within GuestServiceClient:"+url);
		ResponseEntity<Guest[]> response = this.restTemplate.getForEntity(url, Guest[].class);
		return Arrays.asList(response.getBody());
	}

	public Guest addGuest(Guest guest) {
		String url = guestServiceUrl + GUESTS_URL_PART;
		ResponseEntity<Guest> response = this.restTemplate.postForEntity(url, guest, Guest.class);
		return response.getBody();
	}

	public Guest getGuest(long id) {
		String url = guestServiceUrl + GUESTS_URL_PART + SLASH + id;
		ResponseEntity<Guest> response = this.restTemplate.getForEntity(url, Guest.class);
		return response.getBody();
	}

	public void updateGuest(Guest guest) {
		String url = guestServiceUrl + GUESTS_URL_PART + SLASH + guest.getGuestId();
		this.restTemplate.put(url, guest);
	}

	public void deleteGuest(long id) {
		String url = guestServiceUrl + GUESTS_URL_PART + SLASH + id;
		this.restTemplate.delete(url);
	}

}
