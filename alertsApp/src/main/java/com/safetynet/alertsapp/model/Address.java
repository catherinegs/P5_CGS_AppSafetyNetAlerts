package com.safetynet.alertsapp.model;

import lombok.Data;

@Data
public class Address {
	
    private String address;
    private String city;
    private int zip;
    
	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", zip=" + zip + "]";
	}


}
