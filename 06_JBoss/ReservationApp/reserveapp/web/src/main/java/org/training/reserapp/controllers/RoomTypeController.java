package org.training.reserapp.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.training.reserveapp.model.RoomType;
import org.training.reserveapp.service.RoomTypeService;

@WebServlet(urlPatterns={"/room_type"})
public class RoomTypeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    RoomTypeService roomTypeService;
    public RoomTypeController() {
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
            case "remove":
                remove(request, response);
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
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("editroom.jsp");
        request.getRequestDispatcher("editroom.jsp").forward(request, response);
        //dispatcher.forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomName = request.getParameter("roomName");
        String price = request.getParameter("price");

        long roomPrice = Long.parseLong(price);
        RoomType room = new RoomType(roomName, roomPrice);
        roomTypeService.add(room);
        list(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RoomType> list = roomTypeService.findAllRoomType();
        request.setAttribute("list", list);
        request.getRequestDispatcher("roomtype.jsp").forward(request, response);
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/roomtype.jsp");
//        dispatcher.forward(request, response);
    }
}
