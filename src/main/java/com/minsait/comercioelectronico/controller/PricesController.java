package com.minsait.comercioelectronico.controller;

import com.minsait.comercioelectronico.model.SearchPricesRequestBean;
import com.minsait.comercioelectronico.model.SearchPricesResponseBean;
import com.minsait.comercioelectronico.service.PricesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PricesController {

    @Autowired
    private PricesService pricesService;

    @PostMapping(value = "/price", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SearchPricesResponseBean> searchPrice(@RequestBody SearchPricesRequestBean searchPricesRequestBean) {
        log.info("searchPricesRequestBean = " + searchPricesRequestBean);
        SearchPricesResponseBean searchPriceResponseBean = new PricesService()
                .getPricesResponsesBean(pricesService
                        .searchPrices(searchPricesRequestBean.getDate(), searchPricesRequestBean.getProductId(),searchPricesRequestBean.getBrandId()
                        )
                );
        return new ResponseEntity<SearchPricesResponseBean>(searchPriceResponseBean,HttpStatus.OK);
    }
}
