-- V1__init.sql

CREATE TABLE bean (
  id BIGSERIAL PRIMARY KEY,
  bean_name VARCHAR(255) NOT NULL,
  bean_image_url TEXT,
  roastery VARCHAR(255),
  country VARCHAR(100),
  region VARCHAR(100),
  farm VARCHAR(255),
  producer VARCHAR(255),
  variety VARCHAR(255),
  altitude INTEGER,
  process VARCHAR(100),
  roasting_point INTEGER,
  roasting_date DATE,
  price INTEGER,
  purchase_url TEXT
);

CREATE TABLE bean_tasting_log (
  id BIGSERIAL PRIMARY KEY,
  bean_id BIGINT NOT NULL REFERENCES bean(id) ON DELETE CASCADE,
  tasting_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  bean_score SMALLINT CHECK (bean_score BETWEEN 0 AND 100),
  tasting_note TEXT
);

CREATE INDEX idx_tasting_log_bean_id ON bean_tasting_log(bean_id);

CREATE TABLE cup_note (
  id BIGSERIAL PRIMARY KEY,
  tag_name TEXT NOT NULL
);

CREATE TABLE bean_tasting_log_cup_note_relation (
  id BIGSERIAL PRIMARY KEY,
  bean_tasting_log_id BIGINT NOT NULL REFERENCES bean_tasting_log(id) ON DELETE CASCADE,
  cup_note_id BIGINT NOT NULL REFERENCES cup_note(id) ON DELETE RESTRICT,
  type VARCHAR(30) NOT NULL CHECK (type IN ('FLAVOR','AROMA','AFTERTASTE','ACIDITY')),
  UNIQUE (bean_tasting_log_id, cup_note_id, type)
);

CREATE INDEX idx_btlog_rel_btlog_id ON bean_tasting_log_cup_note_relation(bean_tasting_log_id);

CREATE TABLE bean_cup_note_relation (
  id BIGSERIAL PRIMARY KEY,
  bean_id BIGINT NOT NULL REFERENCES bean(id) ON DELETE CASCADE,
  cup_note_id BIGINT NOT NULL REFERENCES cup_note(id) ON DELETE RESTRICT,
  type VARCHAR(30) NOT NULL CHECK (type IN ('FLAVOR','AROMA','AFTERTASTE','ACIDITY')),
  UNIQUE (bean_id, cup_note_id, type)
);

CREATE INDEX idx_bean_rel_bean_id ON bean_cup_note_relation(bean_id);

CREATE TYPE beverage_type AS ENUM ('HOT', 'ICED');

CREATE TABLE recipe (
  id BIGSERIAL PRIMARY KEY,
  beverage_type beverage_type NOT NULL,
  dripper VARCHAR(100),
  filter VARCHAR(100),
  grinder VARCHAR(100),
  grind_setting INTEGER,
  recommend_roasting_point VARCHAR(50),
  water_temperature SMALLINT CHECK (water_temperature BETWEEN 0 AND 110),
  bean_weight NUMERIC(6,2),
  water_weight NUMERIC(6,2),
  recipe_url TEXT
);

CREATE TABLE pouring_step (
  id BIGSERIAL PRIMARY KEY,
  recipe_id BIGINT NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
  step_name VARCHAR(100),
  step_note VARCHAR(255),
  step_time VARCHAR(30),
  step_order_index INTEGER NOT NULL,
  UNIQUE (recipe_id, step_order_index)
);

CREATE INDEX idx_pouring_step_recipe_id ON pouring_step(recipe_id);