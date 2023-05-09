package HW8;

import HW5.MyWaiters;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task4 {
    WebDriver driver;
    @Test(dataProvider = "search")
    public void searchTest(String searchParams, String rezalt) {
        ChromeOptions options = new ChromeOptions(); //экземпляр класса Хром
        options.addArguments("--disable-notifications"); //просим закрыть модальное окно
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
        element1.sendKeys(searchParams);
        element1.sendKeys(Keys.ENTER);
        //h1[text()]
        WebElement resultLine = waiters.presenceOfElementLocatedReturn(By.xpath("//h1[text()]"));
        if (resultLine.getText().contains("Знайдено по запиту")){
        String resultSearch=resultLine.getText().replace("Знайдено по запиту «","").replace("»","");
        assertEquals(resultSearch,rezalt);
        }else if (resultLine.getText().contains("Результати пошуку")){
             String resultSearch= driver.findElement
                    (By.xpath("//div[@class='search-page__box-title']/label")).getText().replace("«","").replace("»","");
            assertEquals(resultSearch,rezalt);
        }
    }

        @DataProvider(name = "search")
        public Object[][] searchObj() {//Object[][]- многомерный массив
            return new Object[][]{
                    {"машина","машина"}, {"input","input"}, {"смысл","смысл"}
            };
        }
    }

