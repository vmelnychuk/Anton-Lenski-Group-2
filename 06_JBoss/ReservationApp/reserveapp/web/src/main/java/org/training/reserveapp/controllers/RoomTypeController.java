package org.training.reserveapp.controllers;


import java.util.List;

import javax.ejb.EJB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.reserveapp.model.Reservation;
import org.training.reserveapp.model.RoomType;
import org.training.reserveapp.service.RoomTypeService;

@Controller
@RequestMapping("/room")
public class RoomTypeController{
    
    private RoomTypeService roomTypeService;
    
    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
/*
    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        long quantity = Long.parseLong(request.getParameter("quantity"));
        RoomType roomType = new RoomType(id, name, price, quantity);
        roomTypeService.update(roomType);
        list(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long roomTypeId = Long.parseLong(request.getParameter("id"));
        RoomType room = new RoomType();
        room.setRoomTypeId(roomTypeId);
        roomTypeService.delete(room);
        list(request, response);

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long roomTypeId = Long.parseLong(request.getParameter("id"));
        RoomType room = new RoomType();
        room.setRoomTypeId(roomTypeId);
        room = roomTypeService.get(room);
        request.setAttribute("item", room);
        request.getRequestDispatcher("editroom.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomName = request.getParameter("roomName");
        String price = request.getParameter("price");

        long roomPrice = Long.parseLong(price);
        RoomType room = new RoomType(roomName, roomPrice);
        roomTypeService.add(room);
        list(request, response);
    }
*/
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<RoomType> rooms = roomTypeService.findAllRoomType();
        model.addAttribute("rooms", rooms);
        return "room";
    }
}
