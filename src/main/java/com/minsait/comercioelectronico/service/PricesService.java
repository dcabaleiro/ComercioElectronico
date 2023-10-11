package com.minsait.comercioelectronico.service;

import com.minsait.comercioelectronico.model.PricesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PricesService {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PricesBean searchPrices(String date, int productId, int brandId){
        String sql = "select brand_id, start_date, end_date, price_list, product_id, priority, price, curr from prices where start_date < PARSEDATETIME(?,'yyyy-MM-dd HH:mm:ss','en') and end_date > PARSEDATETIME(?,'yyyy-MM-dd HH:mm:ss','en') and product_id = ? and brand_id = ? order by priority desc, price desc limit 1;";
        return (PricesBean) jdbcTemplate.queryForObject(sql, new Object[] {date, date, productId, brandId}, new BeanPropertyRowMapper(PricesBean.class));
    }
}
