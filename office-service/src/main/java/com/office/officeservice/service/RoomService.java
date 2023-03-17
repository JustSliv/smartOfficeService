package com.office.officeservice.service;

import com.office.officeservice.model.Room;

public interface RoomService {
    Room save(Room room);

    Room findById(Long roomId);

    Room update(Room room);

    void deleteById(Long roomId);
}
