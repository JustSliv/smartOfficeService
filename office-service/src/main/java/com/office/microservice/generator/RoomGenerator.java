package com.office.microservice.generator;

import com.office.microservice.enums.RoomType;
import com.office.microservice.model.Room;
import com.office.microservice.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class RoomGenerator {

    private RoomService roomService;

    public void generate() {
        roomService.save(createRoom("Developer's room", RoomType.WORK_ROOM, 150));
        roomService.save(createRoom("Small Kitchen", RoomType.KITCHEN, 40));
        roomService.save(createRoom("RestRoom #1", RoomType.REST_ROOM, 20));
        roomService.save(createRoom("Main Server", RoomType.SERVER_ROOM, 100));
    }

    private Room createRoom(String name, RoomType type, double roomSize) {
        return Room.room()
                .roomName(name)
                .roomType(type)
                .roomSize(roomSize)
                .build();
    }
}
