package com.avito;

import org.openqa.selenium.By;

public enum AvitoElement {
    SELECT_CATEGORY(By.id("category")),
    SEARCH_TEXT_FIELD(By.id("search")),
    CHOOSE_REGION(By.cssSelector(".main-location-3j9by")),
    LOCATION_TEXT_FIELD(By.className("suggest-input-3p8yi")),
    FIRST_LOCATION_OPTION(By.xpath("//div[contains(@class,'popup-container')]//li[contains(@class,'suggest-suggest')]")),
    SHOW_RESULTS_BUTTON(By.xpath("//div[contains(@class,'popup-container')]//button[contains(@class,'button')]")),
    CHECKBOX_WITH_DELIVERY(By.xpath("//div[contains(@data-marker,'delivery')]//label[contains(@class,'checkbox')]")),
    CHECKBOX_WITH_PHOTO(By.xpath("//div[contains(@class,'filters-root')]//label[contains(@class,'checkbox')][position()=2]")),
    SEARCH_BUTTON(By.xpath("//div[contains(@class,'applyButton-root')]//button[contains(@class,'button')]")),
    MONEY_FILTER(By.xpath("//div[contains(@class,'index-content')]//select[contains(@class,'select')]")),
    FIELD_WITH_PRODUCTS(By.xpath("//div[contains(@class,'items-items')]")),
    PRODUCT_LIST(By.xpath("//h3[@itemprop='name']")),
    PRICE_LIST(By.xpath("//span[contains(@class,'price-price')]"));

    public final By by;

    AvitoElement(By by) {
        this.by = by;
    }
}