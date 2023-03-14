package com.office.metrics.microservice.enums;

public enum DeviceType {

    TEMPERATURE(1, "Celcium", 10, 25),
    HUMIDITY(2, "Percent", 0, 100),
    LUMINOSITY(3, "Lux", 50, 800),
    SNACK_MACHINE(4, "Piece" ,0, 200),
    DRINK_MACHINE(5, "Piece", 0, 100);

    private int ordinalNumber;
    private String measurementUnit;
    private int minValue;
    private int maxValue;

    DeviceType(int ordinalNumber, String measurementUnit, int minValue, int maxValue) {
        this.ordinalNumber = ordinalNumber;
        this.measurementUnit = measurementUnit;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static DeviceType getByOrdinalNumber(int ordinalNumber) {
        DeviceType deviceType = null;
        switch (ordinalNumber){
            case (0):
                deviceType = TEMPERATURE;
                break;
            case (1):
                deviceType =  HUMIDITY;
                break;
            case (2):
                deviceType =  LUMINOSITY;
            break;
            case (3):
                deviceType =  SNACK_MACHINE;
            break;
            case (4):
                deviceType =  DRINK_MACHINE;
            break;
        }
        return deviceType;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
