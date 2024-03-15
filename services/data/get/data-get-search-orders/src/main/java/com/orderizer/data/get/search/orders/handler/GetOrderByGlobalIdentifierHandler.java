package com.orderizer.data.get.search.orders.handler;

import com.orderizer.data.get.search.orders.repository.api.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static com.selling.system.shared.module.utils.QueryParamsUtil.getQueryParam;

@Component
@RequiredArgsConstructor
public class GetOrderByGlobalIdentifierHandler implements HandlerFunction<ServerResponse> {

    private final OrdersRepository ordersRepository;

    @NotNull
    @Override
    public Mono<ServerResponse> handle(@NotNull ServerRequest request) {
        return getQueryParam(request, "global-identifier", Long::parseLong)
                .flatMap(s -> ordersRepository.findOrderByGlobalIdentifier(s)
                        .flatMap(order -> ServerResponse.ok().bodyValue(order)));
    }
}
