package com.avito;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Elements {

    public void selectCategory(Categories categories) {
        selectFromList(Driver.getDriver().findElement(AvitoElement.SELECT_CATEGORY.by), categories.value);
    }

    public void printInSearchTextField(String string) {
        Driver.getDriver().findElement(AvitoElement.SEARCH_TEXT_FIELD.by).sendKeys(string);
    }

    public void clickChooseRegion() {
        Driver.getDriver().findElement(AvitoElement.CHOOSE_REGION.by).click();
    }

    public void printInLocationTextField(String string) {
        Driver.getDriver().findElement(AvitoElement.LOCATION_TEXT_FIELD.by).sendKeys(string + Keys.ENTER);
        chooseFirstLocationOption();
    }

    public void clickShowResultsButton() {
        Driver.getDriver().findElement(AvitoElement.SHOW_RESULTS_BUTTON.by).click();
    }

    public void clickCheckBoxWithPhoto() {
         Driver.getDriver().findElement(AvitoElement.CHECKBOX_WITH_PHOTO.by).click();
    }

    public void selectMoneyFilter(MoneyFilter moneyFilter) {
        selectFromList(Driver.getDriver().findElement(AvitoElement.MONEY_FILTER.by), moneyFilter.value);
    }

    private void chooseFirstLocationOption() {
        Driver.getDriver().findElement(AvitoElement.FIRST_LOCATION_OPTION.by).click();
    }

    private void selectFromList(WebElement webElement, String string) {
        Select select = new Select(webElement);
        select.selectByValue(string);
    }

    public  void printNameANdPrice(int numberOfItems) {
        WebElement list = Driver.getDriver().findElement(AvitoElement.FIELD_WITH_PRODUCTS.by);
        List<WebElement> printersList = list.findElements(AvitoElement.PRODUCT_LIST.by);
        List<WebElement> priceList = list.findElements(AvitoElement.PRICE_LIST.by);
        System.out.printf("%-65s %-10s\n", "Printer", "Price");
        for (int i = 0; i < numberOfItems; i++) {
            System.out.printf("%-65s %-10s\n", printersList.get(i).getText(), priceList.get(i).getText());
        }
    }
}

