package org.training.reserveapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.reserveapp.model.RoomType;
import org.training.reserveapp.service.RoomTypeService;

//@WebServlet(urlPatterns={"/room_type"})
//public class RoomTypeController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    
//    @EJB
//    private RoomTypeService roomTypeService;
//    public RoomTypeController() {
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action != null) {
//            switch (action) {
//            case "list":
//                list(request, response);
//                break;
//            default:
//                list(request, response);
//                break;
//            }
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action != null) {
//            switch (action) {
//            case "add":
//                add(request, response);
//                break;
//            case "edit":
//                edit(request, response);
//                break;
//            case "remove":
//                remove(request, response);
//                break;
//            case "save":
//                save(request, response);
//                break;
//            default:
//                list(request, response);
//                break;
//            }
//        }
//    }
//    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        long id = Long.parseLong(request.getParameter("id"));
//        String name = request.getParameter("name");
//        long price = Long.parseLong(request.getParameter("price"));
//        long quantity = Long.parseLong(request.getParameter("quantity"));
//        RoomType roomType = new RoomType(id, name, price, quantity);
//        roomTypeService.update(roomType);
//        list(request, response);
//    }
//
//    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        long roomTypeId = Long.parseLong(request.getParameter("id"));
//        RoomType room = new RoomType();
//        room.setRoomTypeId(roomTypeId);
//        roomTypeService.delete(room);
//        list(request, response);
//
//    }
//
//    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        long roomTypeId = Long.parseLong(request.getParameter("id"));
//        RoomType room = new RoomType();
//        room.setRoomTypeId(roomTypeId);
//        room = roomTypeService.get(room);
//        request.setAttribute("item", room);
//        request.getRequestDispatcher("editroom.jsp").forward(request, response);
//    }
//
//    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String roomName = request.getParameter("roomName");
//        String price = request.getParameter("price");
//
//        long roomPrice = Long.parseLong(price);
//        RoomType room = new RoomType(roomName, roomPrice);
//        roomTypeService.add(room);
//        list(request, response);
//    }
//
//    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<RoomType> list = roomTypeService.findAllRoomType();
//        request.setAttribute("list", list);
//        request.getRequestDispatcher("roomtype.jsp").forward(request, response);
//    }
//}

@Controller
@RequestMapping("/room")
public class RoomTypeController {
    private RoomTypeService roomTypeService;
    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<RoomType> list = roomTypeService.findAllRoomType();
        model.addAttribute("rooms", list);
        return "room";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestParam("roomName") String roomName, 
            @RequestParam("price") Long price, Model model) {
        RoomType room = new RoomType(roomName, price);
        roomTypeService.add(room);
        List<RoomType> list = roomTypeService.findAllRoomType();
        model.addAttribute("rooms", list);
        return "room";
    }
}
