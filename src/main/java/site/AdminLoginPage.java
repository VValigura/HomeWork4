package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
    private WebDriver driver;
    private By loginInput = By.id("email");
    private By passInput = By.id("passwd");
    private By enterBtn = By.name("submitLogin");


    public AdminLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    public void setLogin(String login){
        driver.findElement(loginInput).sendKeys(login);
    }

    public void setPassword(String password){
        driver.findElement(passInput).sendKeys(password);
    }

    public void clickEnterButton(){
        driver.findElement(enterBtn).click();
    }

    public void logIn(String login, String password){
        setLogin(login);
        setPassword(password);
        clickEnterButton();
    }

}
