package org.travelslog.brewnote.bean.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.travelslog.brewnote.bean.entity.relation.BeanCupNoteRelation;

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

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "bean")
    private java.util.List<BeanTastingLog> beanTastingLog = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "bean")
    private java.util.List<BeanCupNoteRelation> beanCupNoteRelation = new java.util.ArrayList<>();

    public Bean(String beanName) {
        if (beanName == null || beanName.isBlank()) {
            throw new IllegalArgumentException("beanName must not be blank");
        }
        this.beanName = beanName;
    }
}