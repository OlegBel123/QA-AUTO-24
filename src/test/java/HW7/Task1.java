package HW7;
//Task1:
//Открыть сайт https://dan-it.com.ua/uk/ . На этой странице открыть в новых вкладках ссылки “Java”, “Quality Assurance (QA)”, “FrontEnd”.
//Прописать тест, проверяющий количество открытых окон. Он должен проходить, если количество открытых окон равно 4.
import HW5.MyWaiters;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.security.auth.kerberos.KerberosKey;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class Task1 {
    @Test
    public void Test1(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");// открытие страницы
        //a[text()='Для дорослих']
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[text()='Для дорослих']"));
        actions.moveToElement(element).perform();
        //a[text()='Java']
        //a[text()='Quality Assurance (QA)']
        //a[text()='FrontEnd']
        WebElement elementJava = driver.findElement(By.xpath("//a[text()='Java']"));
        actions.moveToElement(elementJava).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        WebElement elementQualityAssurance = driver.findElement(By.xpath("//a[text()='Quality Assurance (QA)']"));
        actions.moveToElement(elementQualityAssurance).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        WebElement elementFrontEnd = driver.findElement(By.xpath(" //a[text()='FrontEnd']"));
        actions.moveToElement(elementFrontEnd).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        Set<String> masiv = driver.getWindowHandles();
        Iterator<String> i = masiv.iterator();
        assertTrue(masiv.size()==4);
    }
}
