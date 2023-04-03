package com.app.hotel.roomservice.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ROOMS")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private long roomId;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @Column(name = "BED_INFO")
    private String bedInfo;
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBedInfo() {
		return bedInfo;
	}
	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
    
}
