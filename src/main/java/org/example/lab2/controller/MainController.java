package org.example.lab2.controller;

import org.example.lab2.model.Booking;
import org.example.lab2.model.Customer;
import org.example.lab2.model.Tour;
import org.example.lab2.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Controller
public class MainController {

    private final TourService tourService;

    @Autowired
    public MainController(TourService tourService) {
        this.tourService = tourService;
    }

    @RequestMapping({"/", "/index"})
    public String home(Model model) {
        Collection<Tour> tours = tourService.getAllTours();

        model.addAttribute("tours", tours);

        return "listTours";
    }

    @RequestMapping("/tours/{id}")
    public String tourDetail(@PathVariable String id, Model model) {
        model.addAttribute("tourId", id);
        Long tourId = Long.parseLong(id);
        model.addAttribute("tour", tourService.getTour(tourId));
        return "tourDetail";
    }


    @RequestMapping("/book/{id}")
    public String bookTour(@PathVariable String id, Model model){
        model.addAttribute("tourId", id);
        Long tourId = Long.parseLong(id);
        Tour tour = tourService.getTour(tourId);
        Booking booking = new Booking(new Customer(), null, 0, 0, tour); // hoặc để trống nếu dùng form nhập

        model.addAttribute("bookingForm", booking);
        model.addAttribute("tour", tour);
        return "bookTour";
    }
    @PostMapping("/book")
    public String handleBooking(@ModelAttribute("bookingForm") Booking form, Model model) {
        Long tourId = form.getTour().getId();
        Tour tour = tourService.getTour(tourId);
        form.setTour(tour);

        // Tạo booking
        Booking booking = form;
        tourService.saveBooking(booking);
        model.addAttribute("booking", booking);

        return "confirm";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute("bookingForm") Booking form, Model model) {
        System.out.println("chạy");
        // Tạo Customer từ form
        Customer customer = form.getCustomer();
        tourService.saveCustomer(customer);

        // Tạo booking
        Booking booking = form;
        tourService.saveBooking(booking);

        Collection<Tour> tours = tourService.getAllTours();
        model.addAttribute("tours", tours);

        return "listTours";
    }
}
