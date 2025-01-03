package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final static String screenshotPath = "src/test/resources/screenshots";
    private final static String pageSourcePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screenshotName) {
        Logs.debug("Tomando screenshot");

        final var screenshotFile = ((TakesScreenshot) new WebDriverProvider().get())
                .getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath, screenshotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            Logs.error("Error tomar screenshot: %s", ioException.getLocalizedMessage());
        }
    }

    public static void getPageSource(String fileName) {
        Logs.debug("Getting page source");

        final var path = String.format("%s/%s.html", pageSourcePath, fileName);
        try {
            final var file = new File(path);
            Logs.debug("Making parent directories if not existent");
            if (file.getParentFile().mkdirs()) {
                final var fileWriter = new FileWriter(file);
                final var pageSource = new WebDriverProvider().get().getPageSource();
                fileWriter.write(Jsoup.parse(pageSource).toString());
                fileWriter.close();
            }
        } catch (IOException ioException) {
            Logs.error("Taking page source failure: %s", ioException.getLocalizedMessage());
        }
    }

    public static void deletePreviousEvidence() {
        try {
            Logs.debug("Borrando la carpeta de evidencias");
            FileUtils.deleteDirectory(new File(screenshotPath));
            FileUtils.deleteDirectory(new File(pageSourcePath));
        } catch (IOException ioException) {
            Logs.info("Error al borrar la evidencia anterior: %s",
                    ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "screenshot", type = "img/pgn")
    public static byte[] getScreenshot() {
        return ((TakesScreenshot) new WebDriverProvider().get())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "pageSource", type = "text/html", fileExtension = "txt")
    public static String getPageSource() {
        return Jsoup.parse(new WebDriverProvider().get().getPageSource()).toString();
    }


}

