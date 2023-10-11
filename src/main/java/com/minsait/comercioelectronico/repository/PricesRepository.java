package com.minsait.comercioelectronico.repository;

import com.minsait.comercioelectronico.model.PricesBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricesRepository extends JpaRepository<PricesBean,Integer> {
}
