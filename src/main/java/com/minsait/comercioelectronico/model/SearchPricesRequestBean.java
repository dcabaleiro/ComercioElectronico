package com.minsait.comercioelectronico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchPricesRequestBean {

    private String date;
    private int productId;
    private int brandId;
}
