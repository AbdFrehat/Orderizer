package com.orderizer.export.data.json.model.field;

import lombok.Data;

@Data
public class ListRangeDateField implements Field {

    private String field;

    private RangeDateField rangeDateField;
}
