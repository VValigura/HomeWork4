package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminProductsPage {
    private WebDriver driver;
    private By addNewProduct = By.cssSelector(".m-b-2");


    public AdminProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddNewProductBtn(){
        driver.findElement(addNewProduct).click();
    }
}
