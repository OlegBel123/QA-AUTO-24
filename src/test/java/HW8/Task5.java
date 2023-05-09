package HW8;

import HW5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Task5 {
    WebDriver driver;
    @Test
    @Parameters({"Imput"})
    public void searchTest(String searchParams) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //закрываем модальное окно
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().window().maximize(); //вызов большого окна
        MyWaiters waiters = new MyWaiters(driver);
        //a[@class='button user-confirm-location-button']
        //input[@type='search']//поисковая строка
        WebElement element = waiters.presenceOfElementLocatedReturn(By.xpath("//a[@class='button user-confirm-location-button']"));
        element.click();
        WebElement element1 =waiters.waitForVisibilityOfElementLocatedReturn(By.xpath("//input[@type='search']"));
        String str1 = searchParams;
        element1.sendKeys(str1);
        element1.sendKeys(Keys.ENTER);
        //h1[text()]
        WebElement resultLine = waiters.presenceOfElementLocatedReturn(By.xpath("//h1[text()]"));
        if (resultLine.getText().contains("Знайдено по запиту")){
            String resultSearch=resultLine.getText().replace("Знайдено по запиту «","").replace("»","");
            assertEquals(resultSearch,str1);
        }else if (resultLine.getText().contains("Результати пошуку")){
            String resultSearch= driver.findElement
                    (By.xpath("//div[@class='search-page__box-title']/label")).getText().replace("«","").replace("»","");
        }
    }
    }

