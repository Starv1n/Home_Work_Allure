package stepdefs;

import com.avito.Categories;
import com.avito.Elements;
import com.avito.MoneyFilter;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import utilities.Encoder;

import java.io.UnsupportedEncodingException;
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
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver() {
        Driver.closeDriver();
    }

    @Пусть("открыт ресурс Авито")
    public void openSite() {
        Driver.getDriver().get("https://www.avito.ru/");
        element = new Elements();
    }

    @Пусть("в выпадающием списке категорий выбрана {categories}")
    public void selectCategory(Categories category) {
        element.selectCategory(category);
    }

    @Пусть("^в поле поиска введено значение (.*)$")
    public void printInSearchTextField(String string) {
        element.printInSearchTextField(string);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void clickChooseRegion() {
        element.clickChooseRegion();
    }

    @Тогда("^в поле региона введено значение (.*)$")
    public void printInLocationTextField(String string) {
        element.printInLocationTextField(string);
    }

    @Тогда("нажата кнопка показать объявления")
    public void clickShowResultsButton() {
        element.clickShowResultsButton();
    }

    @Тогда("^открыласть страница результатов по запросу (.*)$")
    public void checkIfNeededSiteOpened(String string) throws UnsupportedEncodingException {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(Encoder.encodeValue(string)));
    }

    @Тогда("активирован чекбокс только с фотографией")
    public void clickCheckBoxWithPhoto() {
        element.clickCheckBoxWithPhoto();
    }

    @Тогда("в выпадающем списке сортировки выбрано {moneyFilter}")
    public void selectMoneyFilter(MoneyFilter moneyFilter) {
        element.selectMoneyFilter(moneyFilter);
    }

    @Тогда("^в консоль выведено название и цена (\\d+) первых товаров$")
    public void printNameANdPrice(Integer int1) {
        element.printNameANdPrice(int1);
    }
}
