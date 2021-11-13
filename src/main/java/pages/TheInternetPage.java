package pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheInternetPage {
    private WebDriver driver;

    private By fileUpload = By.linkText("File Upload");
    private By dynamicLoading = By.linkText("Dynamic Loading");


    public TheInternetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFileUpload(){

        ElementActions.click(driver, fileUpload);

    }
    public void clickOnDynamicLoading(){

        ElementActions.click(driver, dynamicLoading);
    }
}
