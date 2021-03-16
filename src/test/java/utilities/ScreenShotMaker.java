package utilities;

import driver.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ScreenShotMaker {

    public static void addAttach() {
        Allure.addAttachment("Avito_" + System.currentTimeMillis() + ".png",
                byteArray(image()));
    }
    public static void addAttachFullScreen() {
        Allure.addAttachment("Avito_" + System.currentTimeMillis() + ".png",
                byteArray(imageFullscreen()));
    }

    public static void addAttachWebElement(By by){
        Allure.addAttachment("Avito_" + System.currentTimeMillis() + ".png",
                byteArray(imageWithWebElement(by)));
    }
    public static void addAttachWebElementWithBlur(By by){
        Allure.addAttachment("Avito_" + System.currentTimeMillis() + ".png",
                byteArray(imageWithWebElementBlur(by)));
    }

    private static BufferedImage image() {
        return new AShot()
                .takeScreenshot(Driver.getDriver()).getImage();
    }

    private static BufferedImage imageFullscreen() {
        return new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(Driver.getDriver())
                .getImage();
    }

    private static BufferedImage imageWithWebElement(By by) {
        return new AShot()
                .takeScreenshot(Driver.getDriver(),Driver.getDriver().findElement(by))
                .getImage();
    }

    private static BufferedImage imageWithWebElementBlur(By by) {
        return new AShot()
                .imageCropper(new IndentCropper().addIndentFilter(new BlurFilter()))
                .takeScreenshot(Driver.getDriver(), Driver.getDriver().findElement(by))
                .getImage();
    }

    private static ByteArrayInputStream byteArray(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
