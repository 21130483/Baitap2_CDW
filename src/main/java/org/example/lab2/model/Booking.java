package org.example.lab2.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Booking {
	public long id;
	private Customer customer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;
	private int noAdults;
	private int noChildren;
	private Tour tour;

	public Booking(Customer customer, LocalDate departureDate, int noAdults,
			int noChildren, Tour tour) {
		this.customer = customer;
		this.departureDate = departureDate;
		this.noAdults = noAdults;
		this.noChildren = noChildren;
		this.tour = tour;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public int getNoAdults() {
		return noAdults;
	}

	public void setNoAdults(int noAdults) {
		this.noAdults = noAdults;
	}

	public int getNoChildren() {
		return noChildren;
	}

	public void setNoChildren(int noChildren) {
		this.noChildren = noChildren;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", customer=" + customer +
				", departureDate=" + departureDate +
				", noAdults=" + noAdults +
				", noChildren=" + noChildren +
				", tour=" + tour +
				'}';
	}
}
