package org.travelslog.brewnote.bean.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.travelslog.brewnote.bean.entity.relation.BeanCupNoteRelation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bean")
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Bean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private Integer altitude; // 재배 고도
    private String process; // 가공 방식

    @Column(name = "roasting_point")
    private Integer roastingPoint; // 로스팅 포인트
    @Column(name = "roasting_date")
    private LocalDate roastingDate;  // 로스팅 날짜

    private Integer price;
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @PrePersist
    void prePersist() {
        var now = OffsetDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    void preUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }

    @OneToMany(mappedBy = "bean")
    private java.util.List<BeanTastingLog> beanTastingLog = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "bean")
    private java.util.List<BeanCupNoteRelation> beanCupNoteRelation = new java.util.ArrayList<>();


    // Bean 객체 기본 메소드
    private static void requireNotBlank(String value, String msg) {
        if (value == null || value.isBlank()) 
            throw new IllegalArgumentException(msg);
    }

    public Bean(String beanName) {
        requireNotBlank(beanName, "beanName must not be blank");
        this.beanName = beanName;
    }

    public void update(String beanName, String roastery, Integer price, String beanImageUrl, String purchaseUrl, String country, String region, String farm, String producer, String variety, Integer altitude, String process, Integer roastingPoint, LocalDate roastingDate) {
        if (beanName != null) {
            requireNotBlank(beanName, "beanName must not be blank");
            this.beanName = beanName;
        }
        if (roastery != null) {
            requireNotBlank(roastery, "roastery must not be blank");
            this.roastery = roastery;
        }
        if (price != null) {
            if (price < 0) throw new IllegalArgumentException("price must not be negative");
            this.price = price;
        }
        if (beanImageUrl != null) {
            requireNotBlank(beanImageUrl, "beanImageUrl must not be blank");
            this.beanImageUrl = beanImageUrl;
        }
        if (purchaseUrl != null) {
            requireNotBlank(purchaseUrl, "purchaseUrl must not be blank");
            this.purchaseUrl = purchaseUrl;
        }
        if (country != null) {
            requireNotBlank(country, "country must not be blank");
            this.country = country;
        }
        if (region != null) {
            requireNotBlank(region, "region must not be blank");
            this.region = region;
        }
        if (farm != null) {
            requireNotBlank(farm, "farm must not be blank");
            this.farm = farm;
        }
        if (producer != null) {
            requireNotBlank(producer, "producer must not be blank");
            this.producer = producer;
        }
        if (variety != null) {
            requireNotBlank(variety, "variety must not be blank");
            this.variety = variety;
        }
        if (altitude != null) {
            if (altitude < 0) throw new IllegalArgumentException("altitude must not be negative");
            this.altitude = altitude;
        }
        if (process != null) {
            requireNotBlank(process, "process must not be blank");
            this.process = process;
        }
        if (roastingPoint != null) {
            if (roastingPoint < 0) throw new IllegalArgumentException("roastingPoint must not be negative");
            this.roastingPoint = roastingPoint;
        }
        if (roastingDate != null) {
            this.roastingDate = roastingDate;
        }
    }

    // Bean 객체의 연관 관계 메소드
    public void addBeanTastingLog(BeanTastingLog beanTastingLog) {
        this.beanTastingLog.add(beanTastingLog);
        if (beanTastingLog.getBean() != this) {
            beanTastingLog.setBean(this);
        }
    }
}