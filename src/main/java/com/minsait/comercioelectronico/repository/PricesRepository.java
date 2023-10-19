package com.minsait.comercioelectronico.repository;

import com.minsait.comercioelectronico.model.PricesBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<PricesBean,Integer> {
    @Query(value = "select brand_id, start_date, end_date, price_list, product_id, priority, price, curr from prices where start_date < PARSEDATETIME( :date ,'yyyy-MM-dd HH:mm:ss','en') and end_date > PARSEDATETIME( :date,'yyyy-MM-dd HH:mm:ss','en') and product_id = :product_id and brand_id = :brand_id order by priority desc, price desc limit 1", nativeQuery = true)
    PricesBean searchPrices(@Param("date") String start_date, @Param("product_id") int product_id, @Param("brand_id") int brand_id);

}
