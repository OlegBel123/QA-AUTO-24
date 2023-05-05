package HW7;
//Task2:
//Открыть сайт https://uhomki.com.ua/ru/.  Проверить, что после нажатия кнопки “ Оплата и доставка” открывается страница с нужной ссылкой.
//А именно https://uhomki.com.ua/ru/oplata-i-dostavka/.
import HW5.MyWaiters;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//Task2:
//Открыть сайт https://uhomki.com.ua/ru/.  Проверить, что после нажатия кнопки “ Оплата и доставка” открывается страница с нужной ссылкой.
//А именно https://uhomki.com.ua/ru/oplata-i-dostavka/.
public class Task2 {
    @Test
    public void Test2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");// открытие страницы
        //a[contains(text(),'Оплата и доставка')]
        // Нажатие на кнопку "Оплата и доставка"
        WebElement paymentAndDelivery = driver.findElement(By.xpath("//a[contains(text(),'Оплата и доставка')]"));
        paymentAndDelivery.click();// "Оплата и доставка"
        // Проверяем, что правильная страница открыта
        String expectedUrl = "https://uhomki.com.ua/ru/oplata-i-dostavka/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Тест пройден");
        driver.quit();

    }
}
