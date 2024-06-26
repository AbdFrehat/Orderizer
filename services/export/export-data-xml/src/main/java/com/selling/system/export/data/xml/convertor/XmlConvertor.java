package com.selling.system.export.data.xml.convertor;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.selling.system.export.shared.convertor.DataConvertor;
import com.orderizer.core.models.commands.ExportDataFilter;
import com.orderizer.core.models.entities.Sale;
import com.orderizer.core.models.wrappers.Sales;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class XmlConvertor implements DataConvertor {

    private final XmlMapper xmlMapper;

    public XmlConvertor(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    @Override
    public Mono<byte[]> convert(Flux<Sale> salesFlux, ExportDataFilter exportDataFilter) {
        return salesFlux.collectList()
                .flatMap(sales -> Mono.fromCallable(() -> xmlMapper.writeValueAsString(new Sales(sales))))
                .map(String::getBytes)
                .onErrorMap(e -> new RuntimeException("Error processing JSON", e));
    }
}
