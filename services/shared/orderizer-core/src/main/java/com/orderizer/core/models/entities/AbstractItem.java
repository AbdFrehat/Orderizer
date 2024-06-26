package com.orderizer.core.models.entities;

import java.math.BigDecimal;
import java.util.List;

public interface AbstractItem {
    String getName();

    List<String> getTags();

    BigDecimal getPrice();

    int getQuantity();
}
