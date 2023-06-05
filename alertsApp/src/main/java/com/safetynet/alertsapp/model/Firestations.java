package com.safetynet.alertsapp.model;



public class Firestations {
	
	private String station;
	private Address address;
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Firestations(String station, Address address) {
		super();
		this.station = station;
		this.address = address;
	}
	public Firestations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
