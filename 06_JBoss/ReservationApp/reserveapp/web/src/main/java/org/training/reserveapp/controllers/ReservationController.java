package org.training.reserveapp.controllers;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.reserveapp.model.Attendee;
import org.training.reserveapp.model.Reservation;
import org.training.reserveapp.model.ReservationStatus;
import org.training.reserveapp.model.RoomType;
import org.training.reserveapp.service.ReservationService;
import org.training.reserveapp.service.RoomTypeService;

@Controller
@RequestMapping("/reservation")
public class ReservationController{

    private ReservationService reservationService;
    private RoomTypeService roomTypeService;
    
    @Autowired
    public ReservationController(RoomTypeService roomTypeService, ReservationService reservationService) {
        this.roomTypeService = roomTypeService;
        this.reservationService = reservationService;
    }
/*
    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long reservationId = Long.parseLong(request.getParameter("id"));
        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservationService.delete(reservation);
        list(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        long attendeeId = Long.parseLong(request.getParameter("attendeeId"));
        long roomTypeId = Long.parseLong(request.getParameter("roomTypeId"));
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        
        Attendee attendee = new Attendee(firstName, lastName, email);
        attendee.setAttendeeId(attendeeId);
       
        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(roomTypeId);
        roomType = roomTypeService.get(roomType);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date checkinDate = dateFormat.parse(checkIn);
            Date checkoutDate = dateFormat.parse(checkOut);
            Reservation reservation = new Reservation(attendee, roomType, checkinDate, checkoutDate, ReservationStatus.Active);
            reservation.setReservationId(id);
            reservationService.update(reservation);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
            list(request, response);
        }
        list(request, response);

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long reservationId = Long.parseLong(request.getParameter("id"));
        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation = reservationService.get(reservation);
        request.setAttribute("item", reservation);
        request.getRequestDispatcher("editreservation.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomType = request.getParameter("roomTypeId");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date checkinDate = dateFormat.parse(checkIn);
            Date checkoutDate = dateFormat.parse(checkOut);
            long roomTypeId = Long.parseLong(roomType);
            Attendee attendee = new Attendee(firstName, lastName, email);
            RoomType room = new RoomType();
            room.setRoomTypeId(roomTypeId);
            room = roomTypeService.get(room);
            Reservation reservation = new Reservation(attendee, room, checkinDate, checkoutDate, ReservationStatus.Active);
            reservationService.add(reservation);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
            list(request, response);
        }
        list(request, response);
    }
    */
    @RequestMapping(method = RequestMethod.GET)
    private String list(Model model) {
        List<RoomType> roomTypes = roomTypeService.findAllRoomType();
        List<Reservation> reservations = reservationService.findAllReservation();
        model.addAttribute("roomTypes", roomTypes);
        model.addAttribute("reservations", reservations);
        return "reservation";
    }
}
