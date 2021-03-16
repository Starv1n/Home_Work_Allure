package stepdefs;

import com.avito.AvitoElement;
import com.avito.Categories;
import com.avito.Elements;
import com.avito.MoneyFilter;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;

import org.testng.Assert;
import utilities.Encoder;
import utilities.ScreenShotMaker;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Steps {

    Elements element;

    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.valueOf(category);
    }

    @ParameterType(".*")
    public MoneyFilter moneyFilter(String filter) {
        return MoneyFilter.valueOf(filter);
    }

    @Before
    public void initDriver() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver() {
        Driver.closeDriver();
    }

    @Пусть("открыт ресурс Авито")
    public void openSite() {
        Driver.getDriver().get("https://www.avito.ru/");
        element = new Elements();
        ScreenShotMaker.addAttach();
    }

    @Пусть("в выпадающием списке категорий выбрана {categories}")
    public void selectCategory(Categories category) {
        element.selectCategory(category);
        ScreenShotMaker.addAttachWebElementWithBlur(AvitoElement.AVITO_HEADER.by);
    }

    @Пусть("^в поле поиска введено значение (.*)$")
    public void printInSearchTextField(String string) {
        element.printInSearchTextField(string);
        ScreenShotMaker.addAttachWebElement(AvitoElement.AVITO_HEADER.by);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void clickChooseRegion() {
        element.clickChooseRegion();
        ScreenShotMaker.addAttach();
    }

    @Тогда("^в поле региона введено значение (.*)$")
    public void printInLocationTextField(String string) {
        element.printInLocationTextField(string);
        ScreenShotMaker.addAttachWebElement(AvitoElement.LOCATION_POPUP_LOCATION.by);
    }

    @Тогда("нажата кнопка показать объявления")
    public void clickShowResultsButton() {
        element.clickShowResultsButton();
        ScreenShotMaker.addAttach();
    }

    @Тогда("^открыласть страница результатов по запросу (.*)$")
    public void checkIfNeededSiteOpened(String string) throws UnsupportedEncodingException {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(Encoder.encodeValue(string)));
        ScreenShotMaker.addAttach();
    }

    @Тогда("активирован чекбокс только с фотографией")
    public void clickCheckBoxWithPhoto() {
        element.clickCheckBoxWithPhoto();
        ScreenShotMaker.addAttachWebElementWithBlur(AvitoElement.CHECKBOX_WITH_PHOTO.by);
    }

    @Тогда("в выпадающем списке сортировки выбрано {moneyFilter}")
    public void selectMoneyFilter(MoneyFilter moneyFilter) {
        element.selectMoneyFilter(moneyFilter);
        ScreenShotMaker.addAttachWebElementWithBlur(AvitoElement.MONEY_FILTER.by);
    }

    @Тогда("^в консоль выведено название и цена (\\d+) первых товаров$")
    public void printNameANdPrice(Integer int1) {
        element.printNameANdPrice(int1);
        ScreenShotMaker.addAttachFullScreen();
    }
}
