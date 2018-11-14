package com.lanou3g.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "tb_item")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field
    private Long itemId;
    @Field
    private String title;
    @Field
    private String sellPoint;
    private Long price;
    private Long num;
    private String barcode;
    private String image;
    private Long cid;
    private Long status;
    private java.sql.Timestamp created;
    private java.sql.Timestamp updated;

}
