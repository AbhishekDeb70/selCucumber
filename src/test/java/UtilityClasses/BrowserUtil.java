package test.java.UtilityClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class BrowserUtil {
        private static WebDriver driver;

        // Method to initialize WebDriver for different browsers
        public static WebDriver getDriver(String browser) {
            if (driver == null) {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        driver = new SafariDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
            return driver;
        }

        // Method to quit WebDriver
        public static void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null; // Reset the driver instance
            }
        }
    }


