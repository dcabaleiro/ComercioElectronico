package com.minsait.comercioelectronico.repository;

import com.minsait.comercioelectronico.model.SearchPricesRequestBean;
import com.minsait.comercioelectronico.model.SearchPricesResponseBean;
import org.springframework.http.ResponseEntity;

public interface PricesDAO {

    ResponseEntity<SearchPricesResponseBean> searchPrice(SearchPricesRequestBean searchPricesRequestBean);
}
