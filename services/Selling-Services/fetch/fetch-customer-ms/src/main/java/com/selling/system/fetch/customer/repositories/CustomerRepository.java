package com.selling.system.fetch.customer.repositories;

import com.selling.system.fetch.customer.models.entites.Sale;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Sale, String> {

    @Query(value = "{ '_id' : ?0 }", fields = "{ 'customer' : 1 }")
    Mono<Sale> findCustomerBySaleId(String saleId);

}