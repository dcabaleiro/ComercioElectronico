package com.minsait.comercioelectronico.controller;

import com.minsait.comercioelectronico.mappers.PricesMapper;
import com.minsait.comercioelectronico.model.SearchPricesResponseBean;
import com.minsait.comercioelectronico.service.PricesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class PricesController {

    @Autowired
    private PricesServiceImpl pricesServiceImpl;

    @GetMapping(value = "/price", produces = "application/json")
    public ResponseEntity<SearchPricesResponseBean> searchPrice(@RequestParam(name = "fecha", value = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, @RequestParam(name = "productId", value = "productId") int productId, @RequestParam(name = "brandId", value = "brandId") int brandId) {
        SearchPricesResponseBean searchPricesResponseBean = PricesMapper.pricesMapper
                .PricesModelToSearchPricesResponseBean(pricesServiceImpl.searchPriceByDateProductIdAndBrandId(date, productId, brandId));
        return new ResponseEntity<SearchPricesResponseBean>(searchPricesResponseBean,HttpStatus.OK);
    }

    @GetMapping(value = "/pricejpql", produces = "application/json")
    public ResponseEntity<SearchPricesResponseBean> searchPriceWithJQPL(@RequestParam(name = "fecha", value = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, @RequestParam(name = "productId", value = "productId") int productId, @RequestParam(name = "brandId", value = "brandId") int brandId) {
        SearchPricesResponseBean searchPricesResponseBean = PricesMapper.pricesMapper
                .PricesModelToSearchPricesResponseBean(pricesServiceImpl.searchPriceWithJPQL(date, productId, brandId));
        return new ResponseEntity<SearchPricesResponseBean>(searchPricesResponseBean,HttpStatus.OK);
    }
}
