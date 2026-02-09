package org.travelslog.brewnote.bean.Entity;

import java.sql.Date;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bean")
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Bean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false)
    private Long id;

    @Column(name = "bean_name", nullable = false)
    private String beanName; // NOT NULL

    @Column(name = "bean_image_url", columnDefinition = "TEXT")
    private String beanImageUrl; // 원두 사진

    @Column(name = "purchase_url", columnDefinition = "TEXT")
    private String purchaseUrl; // 구매 URL

    private String roastery; 
    private String country;
    private String region;
    private String farm;
    private String producer;
    private String variety; // 원두 품종

    private int altitude; // 재배 고도
    private String process; // 가공 방식

    @Column(name = "roasting_point")
    private int roastingPoint; // 로스팅 포인트
    @Column(name = "roasting_date")
    private Date roastingDate;  // 로스팅 날짜

    private int price;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public Bean(String beanName) {
        this.beanName = beanName;
    }

    public Bean(String beanName, String roastery, Integer price) {
        this.beanName = beanName;
        this.roastery = roastery;
        this.price = price;
    }

    public void updateName(String beanName) {
        if (beanName == null || beanName.isBlank()) {
            throw new IllegalArgumentException("beanName must not be blank");
        }
        this.beanName = beanName;
    }
    
    @OneToMany(mappedBy = "beanId")
    private java.util.List<BeanTastingLog> beanTastingLogs;

    @OneToMany(mappedBy = "beanId")
    private java.util.List<BeanCupNote> beanCupNotes;
}