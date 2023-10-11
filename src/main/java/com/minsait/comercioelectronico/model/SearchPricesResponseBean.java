package com.minsait.comercioelectronico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public SearchPricesResponseBean getPricesResponsesBean(PricesBean pricesBean){

        return new SearchPricesResponseBean(pricesBean.getProduct_id(),pricesBean.getBrand_id(), pricesBean.getPrice_list(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pricesBean.getStart_date()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pricesBean.getEnd_date()), pricesBean.getPrice());
    }
}
