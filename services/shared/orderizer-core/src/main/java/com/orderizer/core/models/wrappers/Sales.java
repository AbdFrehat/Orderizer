package com.orderizer.core.models.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orderizer.core.models.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sales {

    @JsonProperty(value = "orders")
    private List<Sale> sales;

}
