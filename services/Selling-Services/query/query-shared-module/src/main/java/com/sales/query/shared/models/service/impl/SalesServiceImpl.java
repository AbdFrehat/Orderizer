package com.sales.query.shared.models.service.impl;

import com.sales.query.shared.models.command.QueryCommand;
import com.sales.query.shared.models.entites.Sale;
import com.sales.query.shared.models.repository.SalesRepository;
import com.sales.query.shared.models.service.QueryBuilderService;
import com.sales.query.shared.models.service.SalesService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * This is an implementation of SalesService interface which acts as a service layer between the controller and the
 * repository.
 * Responsible for:
 * <ul
 *  <li>Building the Query objects.</li>
 *  <li>Paginate the response.</li>
 *  <li>Validate the Request.</li>
 * </ul>
 * @author Abd Frehat
 * @since 1.0
 */
@Service
public class SalesServiceImpl implements SalesService {

    private final QueryBuilderService queryBuilderService;

    private final SalesRepository salesRepository;

    public SalesServiceImpl(QueryBuilderService queryBuilderService, SalesRepository salesRepository) {
        this.queryBuilderService = queryBuilderService;
        this.salesRepository = salesRepository;
    }

    /**
     * This service function responsible to retrieve the filtered sales based on the query command.
     * <ul>
     *     <lu>1. it builds the Query from the received query command.</lu>
     *     <lu>2. calls the getSales method from salesRepository.</lu>
     * </ul>
     *
     * @param queryCommand: {@link QueryCommand} contains the list of fields that the query searches on.
     * @return {@code Flux<Sale>} to be sent back in the response.
     * @author Abd Frehat
     * @since 1.0
     */
    @Override
    public Flux<Sale> getSales(QueryCommand queryCommand) {
        return salesRepository.getSales(queryBuilderService.buildQuery(queryCommand));
    }
}
