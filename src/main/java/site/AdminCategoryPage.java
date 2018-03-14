package site;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCategoryPage {
    private WebDriver driver;
    private By addCategoryButton = By.id("page-header-desc-category-new_category");
    private By successAlert = By.cssSelector("div.alert-success > button");
    private By filterNameInput = By.cssSelector("[name='categoryFilter_name']");
    private By searchCategoryButton = By.cssSelector("#submitFilterButtoncategory");
    public AdminCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddCategoryButton(){
        driver.findElement(addCategoryButton).click();
    }

    public boolean isSuccessAlertVisible(){
        try {
            driver.findElement(successAlert);
            return true;
        } catch (NoSuchElementException x){
            return false;
        }
    }

    public void filtrCategoryByName(String name){
        driver.findElement(filterNameInput).sendKeys(name);
        driver.findElement(searchCategoryButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"table-category\"]//*[contains(text(), '"+name+"')]")));

    }
}
