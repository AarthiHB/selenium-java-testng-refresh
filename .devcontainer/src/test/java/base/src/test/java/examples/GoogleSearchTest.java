
package examples;

import base.BaseCloudTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseCloudTest {

    @Test
    public void search_selenium_java() throws Exception {
        WebDriver remote = createRemoteDriver("Google Search - Selenium Java");
        this.driver = remote;

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver Java TestNG\n");

        assert driver.getTitle().toLowerCase().contains("selenium");
        quit();
    }
}
