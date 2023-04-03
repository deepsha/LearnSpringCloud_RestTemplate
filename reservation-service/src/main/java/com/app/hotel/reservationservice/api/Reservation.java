package com.app.hotel.reservationservice.api;

import com.app.hotel.reservationservice.data.ReservationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor

public class Reservation {

    private long reservationId;
    private long roomId;
    private long guestId;
    private String date;

    public Reservation() {	
    }
    public Reservation(ReservationEntity entity) {
        super();
        this.roomId = entity.getRoomId();
        this.guestId = entity.getGuestId();
        Date date = new Date(entity.getDate().getTime());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = dateFormat.format(date);
        this.reservationId = entity.getReservationId();
    }

    @JsonIgnore
    public ReservationEntity getReservationEntity() throws ParseException {
        ReservationEntity entity = new ReservationEntity();
        entity.setReservationId(this.reservationId);
        entity.setGuestId(this.guestId);
        entity.setRoomId(this.roomId);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(this.date);
        entity.setDate(new java.sql.Date(date.getTime()));
        return entity;
    }

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
    
}
