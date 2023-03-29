package com.office.metrics.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "roomMetricDTO")
@NoArgsConstructor
@AllArgsConstructor
public class RoomMetricDTO {
    private Long roomId;
    private Long metricId;
}
