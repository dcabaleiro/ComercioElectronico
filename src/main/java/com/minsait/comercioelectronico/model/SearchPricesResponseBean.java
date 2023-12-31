package com.minsait.comercioelectronico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchPricesResponseBean {

    private int productId;
    private int brandId;
    private int priceList;
    private String startDate;
    private String endDate;
    private Double price;

}
