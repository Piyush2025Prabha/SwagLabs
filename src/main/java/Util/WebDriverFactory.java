package Util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {
	private static WebDriver Driver;
	public static WebDriver getWebDriver(String bname) throws MalformedURLException {
		if (Driver == null) {
            if (bname.equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--start-maximized");
                // Remote Driver
                Driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                System.out.println("Session created on Google Chrome Browser");

            } else if (bname.equalsIgnoreCase("Firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                Driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                System.out.println("Session created on Firefox Browser");

            } else if (bname.equalsIgnoreCase("Edge")) {
                EdgeOptions options = new EdgeOptions();
                Driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                System.out.println("Session created on Microsoft Edge Browser");

            } else {
                throw new IllegalArgumentException("Browser not supported: " + bname);
            }
		}
		return Driver;
    }

    public static void quitDriver() {
        if (Driver != null) {
        	Driver.quit();
        	Driver = null;
        }
    }

}
