package org.travelslog.brewnote.recipe.entity;

import java.math.BigDecimal;

import org.travelslog.brewnote.recipe.BeverageType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName; // NOT NULL

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(name = "beverage_type", nullable = false)
    private BeverageType beverageType;

    private String dripper;
    private String filter;
    private String grinder;

    @Column(name = "grind_setting")
    private int grindSetting; // 분쇄도

    @Column(name = "recommend_roasting_point")
    private String recommendRoastingPoint; // 추천 로스팅 포인트
    @Column(name = "bean_weight", precision = 6, scale = 2)
    private BigDecimal beanWeight; // 원두량 (g)
    @Column(name = "water_weight", precision = 6, scale = 2)
    private BigDecimal waterWeight; // 물량 (ml)
    @Column(name = "water_temperature")
    private int waterTemperature; // 물 온도 (°C)
    @Column(name = "recipe_url")
    private String recipeUrl; // 추출 레시피 URL

    @OneToMany(
        mappedBy = "recipe",
        cascade = jakarta.persistence.CascadeType.ALL,
        orphanRemoval = true
    )
    @OrderBy("stepOrderIndex ASC") // stepOrderIndex 기준으로 오름차순 정렬
    private java.util.List<PouringStep> pouringStep = new java.util.ArrayList<>();
}