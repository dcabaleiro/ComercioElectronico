package com.minsait.comercioelectronico.service;

import com.minsait.comercioelectronico.model.PricesModel;

import java.util.Date;


public interface PricesService {
    PricesModel searchPriceByDateProductIdAndBrandId(Date date, int productId, int brandId);

    PricesModel searchPriceWithJPQL(Date date, int productId, int brandId);
}
