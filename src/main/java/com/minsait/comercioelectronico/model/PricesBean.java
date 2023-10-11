package com.minsait.comercioelectronico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PricesBean {
    @Column
    int brand_id;

    @Column
    Timestamp start_date;

    @Column
    Timestamp end_date;

    @Column
    int price_list;

    @Id
    int product_id;

    @Column
    int priority;

    @Column
    Double price;

    @Column
    String curr;

}
