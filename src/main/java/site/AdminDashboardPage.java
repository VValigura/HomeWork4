package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDashboardPage {
    private WebDriver driver;
    private By catalogTab = By.id("subtab-AdminCatalog");
    private By categoriesSubTabOfCatalog = By.id("subtab-AdminCategories");
    private By productsSubTabOfCatalog = By.id("subtab-AdminProducts");


    public AdminDashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCategoriesSubTab(){
        Actions actions = new Actions(driver);
        WebElement catalogTabElement = driver.findElement(catalogTab);
        actions.moveToElement(catalogTabElement).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSubTabOfCatalog));
        catalogTabElement.findElement(categoriesSubTabOfCatalog).click();
    }

    public void clickProductsSubTab(){
        Actions actions = new Actions(driver);
        WebElement catalogTabElement = driver.findElement(catalogTab);
        actions.moveToElement(catalogTabElement).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsSubTabOfCatalog));
        catalogTabElement.findElement(productsSubTabOfCatalog).click();
    }


}
