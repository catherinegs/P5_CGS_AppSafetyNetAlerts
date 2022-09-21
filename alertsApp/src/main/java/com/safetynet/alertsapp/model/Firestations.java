package com.safetynet.alertsapp.model;

import lombok.Data;

@Data
public class Firestations {
	
	private int station;
	private Address address;
	
	@Override
	public String toString() {
		return "Firestations [station=" + station + ", address=" + address + "]";
	}
	

}
