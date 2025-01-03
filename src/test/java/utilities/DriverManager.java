package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver() {
        if (runServer) {
            buildRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }

    public void buildLocalDriver() {
        final var headlessMode = System.getProperty("headless") != null;
        var browserProperty = System.getProperty("browser");

        if (browserProperty == null) {
            Logs.debug("Default driver CHROME Assigned");
            browserProperty = "CHROME";
        }

        final var browser = Browser.valueOf(browserProperty.toUpperCase());

        Logs.debug("Driver Initialization: %s", browser);
        Logs.debug("Headless Mode?: %s", headlessMode);
        final var driver = switch (browser) {
            case CHROME -> {
                final var chromeOptions = new ChromeOptions();
                if (headlessMode) {
                    chromeOptions.addArguments("--headless=new");
                }
                yield new ChromeDriver(chromeOptions);
            }
            case EDGE -> {
                final var edgeOptions = new EdgeOptions();
                if (headlessMode) {
                    edgeOptions.addArguments("--headless=new");
                }
                yield new EdgeDriver();
            }
            case FIREFOX -> {
                final var firefoxOptions = new FirefoxOptions();
                if (headlessMode) {
                    firefoxOptions.addArguments("--headless");
                }
                yield new FirefoxDriver();
            }
            case SAFARI -> new SafariDriver();
            
        };

        Logs.debug("Maximizing Screen");
        driver.manage().window().maximize();

        Logs.debug("Deleting Cookies");
        driver.manage().deleteAllCookies();


        Logs.debug("Asignando driver al WebDriver Provider");
        new WebDriverProvider().set(driver);
    }

    public void killDriver() {
        Logs.debug("Killing driver");
        new WebDriverProvider().get().quit();

    }

    public void buildRemoteDriver() {
    }

    private enum Browser {
        CHROME,
        EDGE,
        FIREFOX,
        SAFARI
    }
}
