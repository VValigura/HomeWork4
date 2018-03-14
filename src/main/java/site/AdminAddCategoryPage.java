package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminAddCategoryPage {
    private WebDriver driver;
    private By nameInput = By.id("name_1");
    private By saveBtn = By.id("category_form_submit_btn");

    public AdminAddCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputCategoryName(String category){
        driver.findElement(nameInput).sendKeys(category);
    }

    public void clickSave(){
        driver.findElement(saveBtn).click();
    }



}
