package com.orderizer.kafka.orders.consumer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdersSaveRequest {

    private List<OrderSaveRequest> orders;
}
