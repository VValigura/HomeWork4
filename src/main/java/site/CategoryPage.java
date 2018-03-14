package site;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
    private WebDriver driver;
    private By addCategoryButton = By.id("page-header-desc-category-new_category");
    private By successAlert = By.cssSelector("div.alert-success > button");
    private By sortByNameBtn = By.cssSelector("th:nth-child(3) > span > a:nth-child(2) > i");

    public CategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddCategoryButton(){
        driver.findElement(addCategoryButton).click();
    }

    public boolean isSuccesAlertVisible(){
        try {
            driver.findElement(successAlert);
            return true;
        } catch (NoSuchElementException x){
            return false;
        }
    }

    public void clickSortCategoryByName(){
        driver.findElement(sortByNameBtn).click();
    }
}
