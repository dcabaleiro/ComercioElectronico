package com.minsait.comercioelectronico.controller;

import com.minsait.comercioelectronico.model.PricesBean;
import com.minsait.comercioelectronico.model.SearchPricesRequestBean;
import com.minsait.comercioelectronico.model.SearchPricesResponseBean;
import com.minsait.comercioelectronico.repository.PricesDAO;
import com.minsait.comercioelectronico.service.PricesService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricesController implements PricesDAO {

    @Autowired
    private PricesService pricesService;

    public PricesController() {
    }

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @Override
    @PostMapping(value = "/price", consumes = "application/json", produces = "application/json")
    @Retry(name = "estandar", fallbackMethod = "ErrorSearchPrice")
    public ResponseEntity<SearchPricesResponseBean> searchPrice(@RequestBody SearchPricesRequestBean searchPricesRequestBean) {
        System.out.println("searchPricesRequestBean = " + searchPricesRequestBean);
        PricesBean searchPrice = pricesService.searchPrices(searchPricesRequestBean.getDate(), searchPricesRequestBean.getProductId(),searchPricesRequestBean.getBrandId());
        SearchPricesResponseBean searchPriceResponseBean = new SearchPricesResponseBean().getPricesResponsesBean(searchPrice);
        return new ResponseEntity<SearchPricesResponseBean>(searchPriceResponseBean,HttpStatus.OK);
    }

    public ResponseEntity<SearchPricesResponseBean> ErrorSearchPrice(Exception e){
        SearchPricesResponseBean searchPriceResponseBean = new SearchPricesResponseBean();
        return new ResponseEntity<SearchPricesResponseBean>(searchPriceResponseBean,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
