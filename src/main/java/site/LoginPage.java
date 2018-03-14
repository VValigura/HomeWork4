package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By loginInput = By.id("email");
    private By passInput = By.id("passwd");
    private By enterBtn = By.name("submitLogin");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    public void setLogin(){
        driver.findElement(loginInput).sendKeys("webinar.test@gmail.com");
    }

    public void setPassword(){
        driver.findElement(passInput).sendKeys("Xcg7299bnSmMuRLp9ITw");
    }

    public void clickEnterButton(){
        driver.findElement(enterBtn).click();
    }

}
