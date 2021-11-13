package base;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Base {

    //This class has all setup and closing actions that any test class will need
    public WebDriver driver;

    //setup method that calls the browser driver and open base url
    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    //responsible for closing
    @AfterClass
    public void tearDown() throws InterruptedException {
      //  Thread.sleep(3000);
      //  DriverFactory.closeAllDrivers();

    }
}
