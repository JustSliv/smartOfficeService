package com.office.metrics.microservice.generator;

import com.office.metrics.microservice.enums.DeviceType;
import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.services.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.office.metrics.microservice.enums.DeviceType.*;

@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceGenerator implements DataGenerator{
    private final static int TYPE_COUNT = 5;

    private DeviceService deviceService;

    @Override
    public void generate(int count) {
        int countForType = count / TYPE_COUNT;
        int redundant = count % TYPE_COUNT;

        if (countForType != 0) {
            createDevices(countForType);
        }
        if (redundant != 0) {
            createRedundantDevices(redundant);
        }
    }

    private void createDevices(int countForType) {
        for (int i = 0; i < countForType; i++) {
            deviceService.save(Device.device().type(TEMPERATURE).build());
            deviceService.save(Device.device().type(HUMIDITY).build());
            deviceService.save(Device.device().type(LUMINOSITY).build());
            deviceService.save(Device.device().type(SNACK_MACHINE).maxCapacity(SNACK_MACHINE.getMaxValue()).currentCapacity((int) ((Math.random() * (SNACK_MACHINE.getMaxValue() - SNACK_MACHINE.getMinValue())) + SNACK_MACHINE.getMinValue())).build());
            deviceService.save(Device.device().type(DRINK_MACHINE).maxCapacity(DRINK_MACHINE.getMaxValue()).currentCapacity((int) ((Math.random() * (DRINK_MACHINE.getMaxValue() - DRINK_MACHINE.getMinValue())) + DRINK_MACHINE.getMinValue())).build());
        }
    }

    private void createRedundantDevices(int redundant) {
        for (int i = 0; i < redundant; i++) {
            if (DeviceType.getByOrdinalNumber(i) == SNACK_MACHINE) {
                deviceService.save(Device.device().type(SNACK_MACHINE).maxCapacity(SNACK_MACHINE.getMaxValue()).currentCapacity((int) ((Math.random() * (SNACK_MACHINE.getMaxValue() - SNACK_MACHINE.getMinValue())) + SNACK_MACHINE.getMinValue())).build());
            } else if (DeviceType.getByOrdinalNumber(i) == DRINK_MACHINE) {
                deviceService.save(Device.device().type(DRINK_MACHINE).maxCapacity(DRINK_MACHINE.getMaxValue()).currentCapacity((int) ((Math.random() * (DRINK_MACHINE.getMaxValue() - DRINK_MACHINE.getMinValue())) + DRINK_MACHINE.getMinValue())).build());
            } else {
                deviceService.save(Device.device().type(DeviceType.getByOrdinalNumber(i)).build());
            }
        }
    }
}
