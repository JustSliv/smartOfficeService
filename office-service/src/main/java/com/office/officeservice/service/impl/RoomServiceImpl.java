package com.office.officeservice.service.impl;

import com.office.officeservice.service.RoomService;
import com.office.officeservice.model.Room;
import com.office.officeservice.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;
    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room findById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow();
    }

    @Override
    public Room update(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteById(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
