package com.office.metrics.microservice.enums;

public enum DeviceType {

    TEMPERATURE(1, "Celcium"),
    HUMIDITY(2, "Percent"),
    LUMINOSITY(3, "Lux"),
    SNACK_MACHINE(4, "Piece"),
    DRINK_MACHINE(5, "Piece");

    private int ordinalNumber;
    private String measurementUnit;

    DeviceType(int ordinalNumber, String measurementUnit) {
        this.ordinalNumber = ordinalNumber;
        this.measurementUnit = measurementUnit;
    }
}
