package com.office.microservice.service;

import com.office.microservice.dto.RoomMetricDTO;
import com.office.microservice.model.Room;

public interface RoomService {
    Room save(Room room);

    Room findById(Long roomId);

    Room update(Room room);

    void deleteById(Long roomId);

    void handleMetricFromRoom(RoomMetricDTO roomMetricDTO);
}
