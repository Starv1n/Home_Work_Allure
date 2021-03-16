package utilities;

import driver.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ScreenShotMaker {

    public static void addAttach() {
        Allure.addAttachment("Avito_" + System.currentTimeMillis() + ".png",convertToByteArray(image()));
    }

    private static ByteArrayInputStream convertToByteArray(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(baos.toByteArray());
    }

    private static BufferedImage image() {
        return new AShot().takeScreenshot(Driver.getDriver()).getImage();
    }
}
