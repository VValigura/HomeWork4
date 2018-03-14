package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By allProductLink = By.cssSelector(".all-product-link");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.get("http://prestashop-automation.qatestlab.com.ua");
    }

    public void clickAllProductLink(){
        driver.findElement(allProductLink).click();
    }




}
