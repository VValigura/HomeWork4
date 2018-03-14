package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddNewProductPage {
    private WebDriver driver;
    private By prodactNameField = By.cssSelector("#form_step1_name_1");
    private By quantityTab = By.cssSelector("#tab_step3");
    private By priseTab = By.cssSelector("#tab_step2");
    private By quantityProductField = By.cssSelector("#form_step3_qty_0");
    private By priseProductField = By.cssSelector("#form_step2_price");
    private By activateProductButton = By.cssSelector(".switch-input");
    private By successfulNotification = By.cssSelector("#growls .growl-notice .growl-close");
    private By saveBtn = By.cssSelector("#submit");

    public AdminAddNewProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductName(String prodactName){
        driver.findElement(prodactNameField).sendKeys(prodactName);
    }

    public void clickQuantitiesTab(){
        driver.findElement(quantityTab).click();
    }

    public void clickPriseTab(){
        driver.findElement(priseTab).click();
    }

    public void addProductQuantity(String productQuantity){
        clickQuantitiesTab();
        driver.findElement(quantityProductField).clear();
        driver.findElement(quantityProductField).sendKeys(productQuantity);
    }

    public void addProductPrise(String productPrise){
        clickPriseTab();
        driver.findElement(priseProductField).clear();
        driver.findElement(priseProductField).sendKeys(productPrise);
    }

    public void waitUntilSuccessfulNotificationAppearsAndClose(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulNotification));
        driver.findElement(successfulNotification).click();
    }

    public void clickActivateProductButton(){
        driver.findElement(activateProductButton).click();
        waitUntilSuccessfulNotificationAppearsAndClose();
    }

    public void clickSaveButton(){
        WebElement webElement = driver.findElement(saveBtn);
        webElement.click();
        waitUntilSuccessfulNotificationAppearsAndClose();
    }




}
