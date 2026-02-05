package org.travelslog.brewnote.bean.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "beans")
public class Bean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String beanName; // NOT NULL
    private String beanImageUrl; // 원두 사진
    private String roastery; 
    private String country;
    private String region;
    private String farm;
    private String producer;
    private String variety; // 원두 품종
    private int altitude; // 재배 고도
    private String process; // 가공 방식
    private int roastingPoint; // 로스팅 포인트
    private Date roastingDate;  // 로스팅 날짜
    private int price;
    private String purchaseUrl; // 구매 URL
}