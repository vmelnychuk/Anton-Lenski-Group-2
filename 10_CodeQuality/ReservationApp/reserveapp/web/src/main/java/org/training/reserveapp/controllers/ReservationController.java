package org.training.reserveapp.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.reserveapp.model.Attendee;
import org.training.reserveapp.model.Reservation;
import org.training.reserveapp.model.ReservationStatus;
import org.training.reserveapp.model.RoomType;
import org.training.reserveapp.service.ReservationService;
import org.training.reserveapp.service.RoomTypeService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;
    private RoomTypeService roomTypeService;

    @Autowired
    public ReservationController(ReservationService reservationService,
            RoomTypeService roomTypeService) {
        this.reservationService = reservationService;
        this.roomTypeService = roomTypeService;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(id);
        reservationService.delete(reservation);
        return "redirect:/reservation";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String description(@PathVariable("id") Long id, Model model) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(id);
        reservation = reservationService.get(reservation);
        model.addAttribute("item", reservation);
        return "editreservation";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable("id") Long id,
            @RequestParam("attendeeId") Long attendeeId,
            @RequestParam("roomTypeId") Long roomTypeId,
            @RequestParam("checkIn") String checkIn,
            @RequestParam("checkOut") String checkOut,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email) {
      Attendee attendee = new Attendee(firstName, lastName, email);
      attendee.setAttendeeId(attendeeId);
      RoomType roomType = new RoomType();
      roomType.setRoomTypeId(roomTypeId);
      roomType = roomTypeService.get(roomType);
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date checkinDate = null;
      Date checkoutDate = null;
      try {
          checkinDate = dateFormat.parse(checkIn);
          checkoutDate = dateFormat.parse(checkOut);
          Reservation reservation = new Reservation(attendee, roomType, checkinDate, checkoutDate, ReservationStatus.Active);
          reservation.setReservationId(id);
          reservationService.update(reservation);
      } catch (ParseException e) {
          e.printStackTrace();
      } catch (RuntimeException e) {
          e.printStackTrace();
          return "redirect:/reservation";
      }
      return "redirect:/reservation";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<RoomType> roomTypes = roomTypeService.findAllRoomType();
        List<Reservation> reservations = reservationService.findAllReservation();
        model.addAttribute("roomTypes", roomTypes);
        model.addAttribute("reservations", reservations);
        return "reservation";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestParam("roomTypeId") Long roomTypeId,
            @RequestParam("checkIn") String checkInStr,
            @RequestParam("checkOut") String checkOutStr,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            Model model) {
        Attendee attendee = new Attendee(firstName, lastName, email);
        RoomType room = new RoomType();
        room.setRoomTypeId(roomTypeId);
        room = roomTypeService.get(room);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = null;
        Date checkOut = null;
        try {
            checkIn = dateFormat.parse(checkInStr);
            checkOut = dateFormat.parse(checkOutStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Reservation reservation = new Reservation(attendee, room, checkIn, checkOut, ReservationStatus.Active);
        reservationService.add(reservation);
        return "redirect:reservation";
    }
}