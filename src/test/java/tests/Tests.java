package tests;

import base.Base;
import com.shaft.gui.browser.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.FileUploadPage;
import pages.GooglePage;
import pages.TheInternetPage;


import java.io.IOException;


public class Tests extends Base {
    private TheInternetPage theInternetPage ;
    private FileUploadPage fileUploadPage ;
    private DynamicLoadingPage dynamicLoadingPage;
    private GooglePage googlePage ;


    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
    theInternetPage = new TheInternetPage(driver);
    fileUploadPage = new FileUploadPage(driver);
    dynamicLoadingPage = new DynamicLoadingPage(driver);
    googlePage= new GooglePage(driver);
    }
    @Test(priority = 1)
    public void tc01_uploadImage() throws IOException {

        //read image path
        String imagePath = System.getProperty("user.dir")+"\\Images\\test.jpg";
        System.out.println(imagePath);
        //navigate to the internet page
        driver.navigate().to("https://the-internet.herokuapp.com/");
        //click on upload file
        theInternetPage.clickOnFileUpload();
        //file input with image path
        fileUploadPage.fillInputWithImagePath(imagePath);
        //click upload
        fileUploadPage.clickUpload();
        //verify uploaded
        Assert.assertTrue(fileUploadPage.isFileUploaded());
    }
    @Test(priority = 2)
    public void tc02_dynamicLoading() throws IOException {

        //navigate to the internet page
        BrowserActions.navigateToURL(driver,"https://the-internet.herokuapp.com/");
        //click on dynamic loading
        theInternetPage.clickOnDynamicLoading();
        //click on example 2
        dynamicLoadingPage.openExample2();
        //click start
        dynamicLoadingPage.clickStart();
        //verify uploaded
        Assert.assertTrue(dynamicLoadingPage.isTextDisplayed());

    }
    @Test(priority = 3)
    public void googleTest() throws IOException {


        //Navigate to google
        driver.navigate().to("https://www.google.com/ncr");
        //search for text
        googlePage.searchForText("selenium webdriver");
        String thirdResult = googlePage.getThirdResultText();
        System.out.println(thirdResult);
        //very the text of third result contains the expected result
        Assert.assertTrue(thirdResult.contains("What is Selenium WebDriver?"));

    }




}
