package com.orderizer.core.convertors;

import com.orderizer.core.models.entities.Customer;
import com.orderizer.core.models.entities.Item;
import com.orderizer.core.models.entities.Sale;
import com.orderizer.core.exceptions.business.PayloadBadFormatException;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
public class ObjectToSalesConvertor {

    public static Sale toSale(Object object) {
        if (object instanceof LinkedHashMap<?, ?> list) {
            try {
                String saleId = (String) list.get("id");
                final Date date = toSaleDate(list, saleId);
                return Sale.builder()
                        .id(saleId)
                        .couponUsed((boolean) list.get("couponUsed"))
                        .saleDate(date)
                        .purchaseMethod((String) list.get("purchaseMethod"))
                        .customer(toCustomer(list, saleId))
                        .storeLocation((String) list.get("storeLocation"))
                        .items(toItems((List<?>) list.get("items"), saleId))
                        .build();
            } catch (Exception e) {
                throw new PayloadBadFormatException("Unable to parse the sale part of the payload ");
            }
        } else {
            throw new PayloadBadFormatException("Unable to parse the sale part of the payload ");
        }
    }



    public static List<Sale> toSales(Object object) {
        if (object instanceof List<?> list) {
            try {
                return list.stream().map(ObjectToSalesConvertor::toSale).toList();
            } catch (Exception e) {
                throw new PayloadBadFormatException("Unable to parse the sales part of the payload ");
            }
        } else {
            throw new PayloadBadFormatException("Unable to parse the sales part of the payload ");
        }
    }

    private static Customer toCustomer(Object object, String saleId) {
        if (object instanceof LinkedHashMap<?, ?> list) {
            try {
                return Customer.builder()
                        .age((int) ((LinkedHashMap<?, ?>) list.get("customer")).get("age"))
                        .satisfaction((Integer) ((LinkedHashMap<?, ?>) list.get("customer")).get("satisfaction"))
                        .gender((String) ((LinkedHashMap<?, ?>) list.get("customer")).get("gender"))
                        .email((String) ((LinkedHashMap<?, ?>) list.get("customer")).get("email"))
                        .build();
            } catch (Exception e) {
                log.warn("Unable to parse the customer for payload: {} ", saleId);
                return null;
            }
        } else {
            log.warn("Unable to parse the customer for payload: {} ", saleId);
            return null;
        }
    }

    public static List<Item> toItems(List<?> items, String saleId) {
        try {
            return items.stream().map(item -> (LinkedHashMap<?, ?>) item).map(item -> Item.builder()
                    .name((String) item.get("name"))
                    .price(BigDecimal.valueOf((double) item.get("price")))
                    .quantity((int) item.get("quantity"))
                    .tags((List<String>) item.get("tags"))
                    .build()).toList();
        } catch (Exception e) {
            log.warn("Unable to parse the items for payload: {} ", saleId);
            return null;
        }
    }

    public static Date toSaleDate(LinkedHashMap<?, ?> list, String saleId) {
        try {
            Object saleDate = list.get("saleDate");
            Date date;
            if (saleDate instanceof String) {
                date = Date.from(OffsetDateTime.parse((String) list.get("saleDate"), DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant());
            } else {
                date = new Date((Long) saleDate);
            }
            return date;
        } catch (Exception ex) {
            log.warn("Unable to parse the saleDate of payload: {} ", saleId);
            return null;
        }
    }



}