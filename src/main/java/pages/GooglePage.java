package pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.*;

public class GooglePage {
    private WebDriver driver;

    private By searchField  = By.name("q");
    private By thirdSearchResult = By.xpath("(//div/a/h3)[3]");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForText(String keyword){
        // fill the field with search text
        ElementActions.type(driver,searchField,keyword);
        //press enter
        ElementActions.keyPress(driver,searchField,Keys.ENTER);
    }
    public String getThirdResultText(){
        WebElement thirdSearchResElem = driver.findElement(thirdSearchResult);
        //scroll to the third result element
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView();", thirdSearchResElem);
        //get the text of the third search element
        return driver.findElement(thirdSearchResult).getText();

    }

}
