package com.javaLive.beans;

public class Publisher {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Publisher() {
		super();
		System.out.println("---inside Publisher constructor---");
	}
	
}
