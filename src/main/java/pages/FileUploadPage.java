package pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;

    private By fileInput = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By fileUploaded = By.id("uploaded-files");


    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInputWithImagePath(String imagePath){


       // ElementActions.type(driver,fileInput,imagePath);
        driver.findElement(fileInput).sendKeys(imagePath);
    }
    public void clickUpload(){

        ElementActions.click(driver,uploadBtn);
    }
    public Boolean isFileUploaded(){
        return ElementActions.isElementDisplayed(driver,fileUploaded);
    }

}
