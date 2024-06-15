package com.staffTransport;
//Transport class
public class Transport implements ITransport{
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String distance;
//overloaded constructor of class transport
	public Transport(int id, String name, String email, String phone, String address, String distance) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.distance = distance;
	}
	//getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getDistance() {
		return distance;
	}
	
}
