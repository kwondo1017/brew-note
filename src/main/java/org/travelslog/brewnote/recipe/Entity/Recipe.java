package org.travelslog.brewnote.recipe.entity;

import org.checkerframework.checker.units.qual.C;
import org.travelslog.brewnote.recipe.BeverageType;

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
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName; // NOT NULL

    @Column(name = "beverage_type")
    private BeverageType beverageType; // Hot, Iced

    private String dripper;
    private String filter;
    private String grinder;

    @Column(name = "grind_setting")
    private int grindSetting; // 분쇄도

    @Column(name = "recommend_roasting_point")
    private String recommendRoastingPoint; // 추천 로스팅 포인트
    @Column(name = "coffee_amount")
    private int coffeeAmount; // 원두량 (g)
    @Column(name = "water_amount")
    private int waterAmount; // 물량 (ml)
    @Column(name = "water_temperature")
    private int waterTemperature; // 물 온도 (°C)
    @Column(name = "recipe_url")
    private String recipeUrl; // 추출 레시피 URL

    @OneToMany(
        mappedBy = "recipeId",
        cascade = jakarta.persistence.CascadeType.ALL,
        orphanRemoval = true
    )
    private java.util.List<PouringStep> pouringSteps;
}