package org.training.reserveapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.reserveapp.model.RoomType;
import org.training.reserveapp.service.RoomTypeService;

@Controller
@RequestMapping("/room")
public class RoomTypeController {
    private RoomTypeService roomTypeService;
    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String description(@PathVariable("id") Long id, Model model) {
        RoomType room = new RoomType();
        room.setRoomTypeId(id);
        room = roomTypeService.get(room);
        model.addAttribute("room", room);
        return "editroom";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestParam("roomName") String roomName, 
            @RequestParam("price") Long price, Model model) {
        RoomType room = new RoomType(roomName, price);
        roomTypeService.add(room);
        return "redirect:room";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id) {
        RoomType room = new RoomType();
        room.setRoomTypeId(id);
        roomTypeService.delete(room);
        return "redirect:/room";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable("id") Long id, 
            @RequestParam("name") String name, 
            @RequestParam("price") Long price, 
            @RequestParam("quantity") Long quantity) {
        RoomType roomType = new RoomType(id, name, price, quantity);
        roomTypeService.update(roomType);
        return "redirect:/room";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<RoomType> list = roomTypeService.findAllRoomType();
        model.addAttribute("rooms", list);
        return "room";
    }
}
