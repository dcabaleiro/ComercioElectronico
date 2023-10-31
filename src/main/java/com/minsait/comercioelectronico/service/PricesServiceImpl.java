package com.minsait.comercioelectronico.service;

import com.minsait.comercioelectronico.excepciones.NotFoundException;
import com.minsait.comercioelectronico.model.PricesEntity;
import com.minsait.comercioelectronico.model.PricesModel;
import com.minsait.comercioelectronico.repository.PricesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

import static com.minsait.comercioelectronico.mappers.PricesMapper.pricesMapper;

@Service
@Slf4j
public class PricesServiceImpl implements PricesService{

    @Autowired
    private PricesRepository pricesRepository;

    @PersistenceContext
    private EntityManager em;

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
        List<PricesEntity> price = pricesRepository.searchPriceWithJPQL(date, productId, brandId);
        if (price.isEmpty()){
            throw new NotFoundException();
        }
        return pricesMapper.PricesEntitytoPricesModel(price.get(0));
    }

    @Override
    public PricesModel searchPriceWithJPQLAndQP(Date date, int productId, int brandId) {
        TypedQuery<PricesEntity> query = em.createQuery("select p from PricesEntity p where startDate < :date and endDate > :date and productId = :productId and brandId = :brandId", PricesEntity.class);
        return pricesMapper.PricesEntitytoPricesModel(query
                .setParameter("date", date)
                .setParameter("productId", productId)
                .setParameter("brandId", brandId)
                .setMaxResults(1)
                .getSingleResult());
    }
}
