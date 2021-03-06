package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCategoryPage {
    private WebDriver driver;
    private By nameInput = By.id("name_1");
    private By saveBtn = By.id("category_form_submit_btn");

    public AddCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputCategoryName(){
        driver.findElement(nameInput).sendKeys("new Category");
    }

    public void clickSave(){
        driver.findElement(saveBtn).click();
    }



}
