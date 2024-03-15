package com.orderizer.data.delete.search.orders.route;

import com.orderizer.data.delete.search.orders.handler.DeleteOrdersSearchHandler;
import com.orderizer.data.delete.search.orders.model.request.OrdersDeleteRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

public interface ContractRouter {

    @RouterOperation(path = "/", beanClass = DeleteOrdersSearchHandler.class, beanMethod = "handle",
            operation = @Operation(operationId = "DeleteOrdersSearchHandler", requestBody =
            @RequestBody(content = @Content(schema = @Schema(implementation = OrdersDeleteRequest.class)))))
    RouterFunction<ServerResponse> appRoute(DeleteOrdersSearchHandler deleteOrdersSearchHandler);
}
