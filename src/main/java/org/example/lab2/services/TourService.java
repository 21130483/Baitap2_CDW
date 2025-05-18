package org.example.lab2.services;

import org.example.lab2.model.Booking;
import org.example.lab2.model.Customer;
import org.example.lab2.model.Tour;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class TourService {
	private TourDatabase database;
	
	public TourService() {
		database = TourDatabase.getInstance();
	}
	
	public Collection<Tour> getAllTours(){
		return database.getAllTours();
	}
	
	public Tour getTour(Long id){
		return database.getTourById(id);
	}
	
	public void saveCustomer(Customer customer){
		database.addCustomer(customer);
	}
	
	public void saveBooking(Booking booking){
		database.addBooking(booking);
	}
}
