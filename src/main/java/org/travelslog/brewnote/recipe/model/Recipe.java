package org.travelslog.brewnote.recipe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipeName; // NOT NULL
    private BeverageType beverageType; // Hot, Iced
    private String dripper;
    private String filter;
    private String grinder;
    private int grindSetting; // 분쇄도
    private String recommendRoastingPoint; // 추천 로스팅 포인트
    private int coffeeAmount; // 원두량 (g)
    private int waterAmount; // 물량 (ml)
    private int waterTemperature; // 물 온도 (°C)
    private String recipeUrl; // 추출 레시피 URL
}