package com.office.microservice.controller;

import com.office.microservice.model.Room;
import com.office.microservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RoomController {
    
    private final RoomService roomService;

    @PostMapping("/save")
    public ResponseEntity<Room> save(@RequestBody Room room) {
        return ResponseEntity.ok(roomService.save(room));
    }

    @GetMapping("/findById/{room_id}")
    public ResponseEntity<Room> findById(@PathVariable(name = "room_id") Long roomId) {
        return ResponseEntity.ok(roomService.findById(roomId));
    }

    @DeleteMapping("/deleteById/{room_id}")
    public void deleteById(@PathVariable(name = "room_id") Long roomId) {
        roomService.deleteById(roomId);
    }
}
