package com.minsait.comercioelectronico.service;

import com.minsait.comercioelectronico.excepciones.NotFoundException;
import com.minsait.comercioelectronico.model.PricesEntity;
import com.minsait.comercioelectronico.model.PricesModel;
import com.minsait.comercioelectronico.repository.PricesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.minsait.comercioelectronico.mappers.PricesMapper.pricesMapper;

@Service
@Slf4j
public class PricesServiceImpl implements PricesService{

    @Autowired
    private PricesRepository pricesRepository;

    public PricesEntity searchPrices(String date, int productId, int brandId) {

        PricesEntity pricesEntity = pricesRepository.searchPrices(date, productId, brandId);
        if (pricesEntity == null){
            throw new NotFoundException();
        }
        return pricesEntity;
    }
    @Override
    public PricesModel searchPriceByDateProductIdAndBrandId(Date date, int productId, int brandId) {
        PricesEntity price = pricesRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(date,date, productId, brandId);
        if (price == null){
            throw new NotFoundException();
        }
        return pricesMapper.PricesEntitytoPricesModel(price);
    }

    @Override
    public PricesModel searchPriceWithJPQL(Date date, int productId, int brandId) {
        PricesEntity price = pricesRepository.searchPriceWithJPQL(date, productId, brandId);
        if (price == null){
            throw new NotFoundException();
        }
        return pricesMapper.PricesEntitytoPricesModel(price);
    }
}
