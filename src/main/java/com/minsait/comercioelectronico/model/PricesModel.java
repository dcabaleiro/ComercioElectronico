package com.minsait.comercioelectronico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricesModel {

    private int id;
    private int brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private int priceList;
    private int productId;
    private int priority;
    private Double price;
    private String curr;
}