import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Tests {

    int width = 515;
    int height =500;

    @Test
    public void browserActions_Demo() {
        WebDriver driver = DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://www.google.com/","google");
        DriverFactory.closeAllDrivers();

    }
    
    
}
