package com.selling.system.query.sales.delete.controller;

import com.selling.system.query.shared.module.entites.QueryCommandDTO;
import com.selling.system.query.shared.module.service.QueryResponseService;
import com.selling.system.shared.module.models.responses.QueryResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DeleteSaleController {

    private final QueryResponseService queryResponseService;

    public DeleteSaleController(QueryResponseService queryResponseService) {
        this.queryResponseService = queryResponseService;
    }

    @PostMapping
    Mono<ResponseEntity<QueryResponse>> deleteSale(@RequestBody @Valid QueryCommandDTO queryCommand) {
        return queryResponseService.buildQueryResponse(queryCommand);
    }
}