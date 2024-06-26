package com.orderizer.core.models.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orderizer.core.models.enums.CommandType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Map;

/**
 * This Data class represents the needed fields to query the data and update them.
 *
 * @author Abd Frehat
 * @since 1.0
 */
@Data
@ToString(exclude = "payload")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataCommand implements DataCommandAbstract {

    /**
     * Map of QueryFields which represent the search criteria.
     */
    @JsonProperty(value = "queryFields")
    protected Map<String, @Valid QueryField> queryFields;

    /**
     * The page number of paginated results. Must be greater than zero.
     */
    @JsonProperty(value = "page")
    @Min(value = 0, message = "Page number must be greater than 0 and less than " + Integer.MAX_VALUE)
    protected int page;

    /**
     * The size of result set per page, Must be greater than zero.
     */
    @JsonProperty(value = "size")
    @Min(value = 0, message = "Size number must be greater than 0 and less than " + Integer.MAX_VALUE)
    protected int size;

    /**
     * The QueryMethod specifies which operation will be executed.
     */
    @NotNull(message = "QueryCommand.queryMethod can not be null")
    @JsonProperty(value = "commandType")
    protected CommandType commandType;

    @JsonProperty(value = "sort")
    @Valid
    protected SortField sortField;

    @JsonProperty(value = "exclude")
    private String[] excludedFields;

    /**
     * The payload to do the operation on like DELETE, SAVE and UPDATE object(s)
     */
    @JsonProperty(value = "payload")
    protected Object payload;

    @JsonProperty(value = "expression")
    private String expression;

    @JsonProperty(value = "count")
    private boolean count;


}

