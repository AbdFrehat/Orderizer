package com.orderizer.source.random.generator.orders.model.data;

import com.orderizer.core.models.commons.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsData {

    private List<String> nameValues;

    private PriceRange priceRange;

    private List<String> tagsValues;

    private QuantityRange quantityRange;


    public static class PriceRange extends Range<Integer> {

    }

    public static class QuantityRange extends Range<Integer> {
    }

}




