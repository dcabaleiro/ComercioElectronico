package com.minsait.comercioelectronico.mappers;

import com.minsait.comercioelectronico.model.PricesEntity;
import com.minsait.comercioelectronico.model.PricesModel;
import com.minsait.comercioelectronico.model.SearchPricesResponseBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface PricesMapper {

    PricesMapper pricesMapper = Mappers.getMapper(PricesMapper.class);

    PricesModel PricesEntitytoPricesModel(PricesEntity pricesEntity);

    @Mapping(target ="priceList",source = "priceList")
    SearchPricesResponseBean PricesModelToSearchPricesResponseBean(PricesModel pricesModel);
}
