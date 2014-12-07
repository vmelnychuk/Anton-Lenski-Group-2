package org.training.reserapp.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.reserveapp.model.Attendee;
import org.training.reserveapp.model.Reservation;
import org.training.reserveapp.model.ReservationStatus;
import org.training.reserveapp.model.RoomType;
import org.training.reserveapp.service.ReservationService;
import org.training.reserveapp.service.RoomTypeService;

@WebServlet(urlPatterns={"/reservation"})
public class ReservationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ReservationService reservationService;
    
    @EJB
    private RoomTypeService roomTypeService;
    
    public ReservationController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
            case "list":
                list(request, response);
                break;
            default:
                list(request, response);
                break;
            }
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
            case "add":
                add(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "save":
                save(request, response);
                break;
            default:
                list(request, response);
                break;
            }
        }
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
        }
        list(request, response);
    }
    
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RoomType> roomTypes = roomTypeService.findAllRoomType();
        request.setAttribute("roomTypes", roomTypes);
        List<Reservation> reservations = reservationService.findAllReservation();
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("reservation.jsp").forward(request, response);
    }
}
