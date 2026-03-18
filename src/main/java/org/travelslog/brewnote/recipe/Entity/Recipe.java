package org.travelslog.brewnote.recipe.entity;

import java.math.BigDecimal;

import org.travelslog.brewnote.recipe.entity.command.RecipeUpdateCommand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "beverage_type", nullable = false)
    private BeverageType beverageType;

    private String dripper;
    @Column(name = "filter_name")
    private String filterName;
    private String grinder;

    @Column(name = "grind_setting")
    private Integer grindSetting; // 분쇄도

    @Column(name = "recommend_roasting_point")
    private String recommendRoastingPoint; // 추천 로스팅 포인트
    @Column(name = "bean_weight", precision = 6, scale = 2)
    private BigDecimal beanWeight; // 원두량 (g)
    @Column(name = "water_weight", precision = 6, scale = 2)
    private BigDecimal waterWeight; // 물량 (ml)
    @Column(name = "water_temperature")
    private Integer waterTemperature; // 물 온도 (°C)
    @Column(name = "recipe_url")
    private String recipeUrl; // 추출 레시피 URL

    @OneToMany(
        mappedBy = "recipe",
        cascade = jakarta.persistence.CascadeType.ALL,
        orphanRemoval = true
    )
    @OrderBy("stepOrderIndex ASC") // stepOrderIndex 기준으로 오름차순 정렬
    private java.util.List<PouringStep> pouringSteps = new java.util.ArrayList<>();

    public Recipe(String recipeName, BeverageType beverageType) {
        if (recipeName == null || recipeName.isBlank()) {
            throw new IllegalArgumentException("recipeName must not be blank");
        }
        if (beverageType == null) {
            throw new IllegalArgumentException("beverageType must not be null");
        }
        this.recipeName = recipeName;
        this.beverageType = beverageType;
    }

    public void apply(RecipeUpdateCommand command) {
        if (command.recipeName() != null) {
            if (command.recipeName().isBlank()) {
                throw new IllegalArgumentException("recipeName must not be blank");
            }
            this.recipeName = command.recipeName();
        }
        if (command.beverageType() != null) {
            this.beverageType = command.beverageType();
        }
        if (command.dripper() != null) {
            this.dripper = command.dripper();
        }
        if (command.filterName() != null) {
            this.filterName = command.filterName();
        }
        if (command.grinder() != null) {
            this.grinder = command.grinder();
        }
        if (command.grindSetting() != null) {
            if (command.grindSetting() < 0) {
                throw new IllegalArgumentException("grindSetting must be a non-negative integer");
            }
            this.grindSetting = command.grindSetting();
        }
        if (command.recommendRoastingPoint() != null) {
            this.recommendRoastingPoint = command.recommendRoastingPoint();
        }
        if (command.beanWeight() != null) {
            if (command.beanWeight().compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("beanWeight must be a non-negative number");
            }
            this.beanWeight = command.beanWeight();
        }
        if (command.waterWeight() != null) {
            if (command.waterWeight().compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("waterWeight must be a non-negative number");
            }
            this.waterWeight = command.waterWeight();
        }
        if (command.waterTemperature() != null) {
            if (command.waterTemperature() < 0) {
                throw new IllegalArgumentException("waterTemperature must be a non-negative integer");
            }
            this.waterTemperature = command.waterTemperature();
        }
        if (command.recipeUrl() != null) {
            this.recipeUrl = command.recipeUrl();
        }
    }
}