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
        Booking booking = new Booking(new Customer(), new Date(), 0, 0, tour); // hoặc để trống nếu dùng form nhập

        model.addAttribute("bookingForm", booking);
        model.addAttribute("tour", tour);
        return "bookTour";
    }
    @PostMapping("/book")
    public String handleBooking(@ModelAttribute("bookingForm") Booking form, Model model) {
        // Tạo Customer từ form
        Customer customer = form.getCustomer();
        tourService.saveCustomer(customer);


        Long tourId = form.getTour().getId();
        Tour tour = tourService.getTour(tourId);
        form.setTour(tour);

        // Tạo booking
        Booking booking = form;
        tourService.saveBooking(booking);
        System.out.println(booking.toString());

        // Truyền booking sang trang confirm
        model.addAttribute("booking", booking);

        return "confirm";
    }

    // Hủy và quay lại trang danh sách
    @PostMapping("/cancel")
    public String cancel() {
        return "redirect:/tours";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // phải khớp định dạng từ input
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
