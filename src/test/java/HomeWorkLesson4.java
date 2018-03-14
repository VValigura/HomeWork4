import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import site.*;

import java.util.Date;


//Дополнительно рассмотрите использование таких аннотаций фреймворка TestNG как @Parameters и @DataProvider.
//
//+        На основе примеров из лекции создать Maven проект и подключить к нему библиотеки Selenium и TestNG. https://bitbucket.org/qatestlab_automation/lecture-4
//
//+        Разработать тестовый скрипт, который будет соответствовать следующему сценарию:
//
//        Часть А. Создание продукта:
//+        1. Войти в Админ Панель.
//+        2. Выбрать пункт меню Каталог -> повары и дождаться загрузки страницы продуктов.
//+        3. Нажать «Новый товар» для перехода к созданию нового продукта, дождаться загрузки страницы.
//+        4. Заполнить следующие свойства нового продукта: Название продукта, Количество, Цена. Свойства продукта должны генерироваться случайно (случайное название продукта, количество от 1 до 100, цена от 0.1 ₴ до 100 ₴).
//+        5. После заполнения полей активировать продукт используя переключатель на нижней плавающей панели. После активации продукта дождаться всплывающего уведомления о сохранении настроек и закрыть его.
//+        6. Сохранить продукт нажав на кнопку «Сохранить». Дождаться всплывающего уведомления о сохранении настроек и закрыть его.
//
//        Часть Б. Проверка отображения продукта:
//+        1. Перейти на главную страницу магазина.
//+        2. Перейти к просмотру всех продуктов воспользовавшись ссылкой «Все товары». Добавить проверку (Assertion), что созданный в Админ Панели продукт отображается на странице.
//+        3. Открыть продукт. Добавить проверки, что название продукта, цена и количество соответствует значениям, которые вводились при создании продукта в первой части сценария.
//
//+        Настройте выполнение тестового скрипта таким образом, чтобы при вызове выполнения тестов (mvn test) он выполнился на разных браузерах: Chrome, Firefox, Internet Explorer. Для этого можно в testng.xml воспользоваться возможностью передачи параметров.
//
//+        Дополнительное задание по желанию. Можно подключить ReportNG для генерации удобных отчетов. Для этого воспользуйтесь информацией с официального сайта http://reportng.uncommons.org/ и следующей инструкцией: https://solidsoft.wordpress.com/2011/01/23/better-looking-html-test-reports-for-
//+        testng-with-reportng-maven-guide/
//
//        Примечания:
//+       1. Логику сценария можно разбить на пару методов @Test и настроить цепочку выполнения используя атрибут dependsOnMethods для данной аннотации.
//+        2. Тестовый скрипт должен содержать проверки (assertions) и дополнительный лог действий, который можно увидеть в отчете о прогоне тестов. Для удобства логирование некоторых действий можно вынести в свою реализацию слушателя WebDriverEventListener, речь о котором шла на прошлой лекции.
//+        3. @DataProvider предназначен для передачи тестовых данных в скрипты. Используйте данную аннотацию для передачи логина и пароля в процессе авторизации.
//+        4. @Parameters позволяет передавать параметры из testng.xml. Используйте данную аннотацию для определения того, какой тип драйвера необходимо поднять для теста (Chrome, Firefox или же Internet Explorer.)
//
//        Для доступа в Админ Панель используйте следующие данные:
//        Адрес: http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
//        Логин: webinar.test@gmail.com
//        Пароль: Xcg7299bnSmMuRLp9ITw
//        Магазин доступен по адресу http://prestashop-automation.qatestlab.com.ua/

public class HomeWorkLesson4 {
    private EventFiringWebDriver loggerDriver;

    @BeforeMethod
    @Parameters("browser")
    public void createDriver(String browser){
        WebDriver driver = null;
        if (browser.equals("Chrome")){
            driver = InitWebDriver.initChromeDriver();
        } else if (browser.equals("FireFox")){
            driver = InitWebDriver.initFireFoxDriver();
        } else if (browser.equals("IE")){
            driver = InitWebDriver.initIEDriver();
        }
        loggerDriver = new EventFiringWebDriver(driver);
        loggerDriver.register(new WebDriverLoggerLesson4());
    }

    @DataProvider
    public Object[][] loginData(){
        return new Object[][]{{"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}};
    }


    @Test(dataProvider = "loginData")
    public void createProduct(String login, String password){
        AdminLoginPage loginPage = new AdminLoginPage(loggerDriver);
        loginPage.openPage();
        loginPage.logIn(login, password);
        new AdminDashboardPage(loggerDriver).clickProductsSubTab();
        new AdminProductsPage(loggerDriver).clickAddNewProductBtn();

        AdminAddNewProductPage addNewProductPage = new AdminAddNewProductPage(loggerDriver);

        String productName = "product" + new Date().getTime();
        String productQuantity = String.valueOf((int) (100*Math.random()));
        String productPrise =  String.format("%.2f",100*Math.random());

        addNewProductPage.addProductName(productName);
        addNewProductPage.addProductQuantity(productQuantity);
        addNewProductPage.addProductPrise(productPrise);
        addNewProductPage.clickActivateProductButton();

        MainPage mainPage = new MainPage(loggerDriver);
        mainPage.openPage();
        mainPage.clickAllProductLink();

        AllProductPage allProductPage = new AllProductPage(loggerDriver);
        new Assertion().assertTrue(allProductPage.isGoodPresentByText(productName), "Product:\"" + productName +"\" is not present.");
        allProductPage.clickOnProduct(productName);

        ProductPage productPage = new ProductPage(loggerDriver);
        new Assertion().assertTrue(productPage.getProductName().equals(productName), productPage.getProductName()+ " not equals to " + productName);
        new Assertion().assertTrue(productPage.getProductPrice().equals(productPrise), productPage.getProductPrice()+ " not equals to " + productPrise);
        new Assertion().assertTrue(productPage.getProductPrice().equals(productPrise), productPage.getProductPrice()+ " not equals to " + productPrise);



    }

    @AfterMethod
    public void closeDriver(){
        loggerDriver.quit();
    }
}
