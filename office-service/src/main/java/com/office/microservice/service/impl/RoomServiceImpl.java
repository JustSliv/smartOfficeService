package com.office.microservice.service.impl;

import com.office.microservice.dto.RoomMetricDTO;
import com.office.microservice.service.RoomService;
import com.office.microservice.model.Room;
import com.office.microservice.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class RoomServiceImpl implements RoomService {

    private static final String METRIC_FROM_ROOM_EVENT = "metric-from-room-event";

    private RoomRepository roomRepository;

    @Override
    @Transactional
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    @Transactional(readOnly = true)
    public Room findById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Room update(Room room) {
        return roomRepository.save(room);
    }

    @Override
    @Transactional
    public void deleteById(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    @KafkaListener(topics = METRIC_FROM_ROOM_EVENT)
    public void handleMetricFromRoom(RoomMetricDTO roomMetricDTO) {
        String roomName = findById(roomMetricDTO.getRoomId()).getRoomName();
        log.info("Metric with id={} was produced in the room {}", roomMetricDTO.getMetricId(), roomName);
    }
}
