package com.minsait.comercioelectronico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchPricesResponseBean {

    int product_id;
    int brand_id;
    int price_list;
    String start_date;
    String end_date;
    Double price;

}
