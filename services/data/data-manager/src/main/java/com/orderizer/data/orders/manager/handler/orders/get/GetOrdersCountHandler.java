package com.orderizer.data.orders.manager.handler.orders.get;

import com.orderizer.data.orders.manager.config.LocalAppConfig;
import com.orderizer.data.orders.manager.model.request.OrdersGetRequest;
import com.orderizer.data.orders.manager.model.response.OrdersCountResponse;
import com.selling.system.shared.module.handlers.ClientExceptionHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component

public class GetOrdersCountHandler implements HandlerFunction<ServerResponse> {

    private final WebClient webClient;

    public GetOrdersCountHandler(WebClient.Builder webClientBuilder, LocalAppConfig localAppConfig) {
        this.webClient = webClientBuilder.baseUrl(localAppConfig.getServices().getContextPath().getDataGetOrdersManager()).build();
    }

    @NotNull
    @Override
    public Mono<ServerResponse> handle(@NotNull ServerRequest request) {
        return request.bodyToMono(OrdersGetRequest.class)
                .flatMap(ordersGetRequest -> webClient.post()
                        .uri(uriBuilder -> uriBuilder.path("/search/count").build())
                        .bodyValue(ordersGetRequest)
                        .retrieve()
                        .onStatus(HttpStatusCode::isError, new ClientExceptionHandler("data-get-orders-manager"))
                        .bodyToMono(OrdersCountResponse.class)
                        .flatMap(ServerResponse.ok()::bodyValue));
    }
}