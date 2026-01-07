
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BaseCloudTest {
    protected WebDriver driver;

    protected WebDriver createRemoteDriver(String testName) throws Exception {
        String provider = System.getProperty("CLOUD_PROVIDER", "BROWSERSTACK").toUpperCase();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("name", testName);
        caps.setCapability("build", "Aarthi-Refresh");

        String user = System.getProperty("BSTACK_USERNAME");
        String key  = System.getProperty("BSTACK_ACCESS_KEY");
        URL hub = new URL("https://" + user + ":" + key + "@hub.browserstack.com/wd/hub");
        return new RemoteWebDriver(hub, caps);
    }

    protected void quit() {
        if (driver != null) driver.quit();
    }
}
