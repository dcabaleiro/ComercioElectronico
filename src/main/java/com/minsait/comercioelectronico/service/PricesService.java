package com.minsait.comercioelectronico.service;

import com.minsait.comercioelectronico.excepciones.NotFoundException;
import com.minsait.comercioelectronico.model.PricesBean;
import com.minsait.comercioelectronico.model.SearchPricesResponseBean;
import com.minsait.comercioelectronico.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class PricesService{
    @Autowired
    private PricesRepository pricesRepository;

    public PricesBean searchPrices(String date, int productId, int brandId){
        PricesBean pricesBean = pricesRepository.searchPrices(date, productId, brandId);
        if (pricesBean == null){
            throw new NotFoundException();
        }
        return pricesBean;
    }
    public SearchPricesResponseBean getPricesResponsesBean(PricesBean pricesBean){
        return new SearchPricesResponseBean(pricesBean.getProduct_id(),pricesBean.getBrand_id(), pricesBean.getPrice_list(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pricesBean.getStart_date()), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pricesBean.getEnd_date()), pricesBean.getPrice());
    }
}
