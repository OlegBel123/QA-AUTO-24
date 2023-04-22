package HW2.Zadanie55;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Vidosik {
    public static void main(String[] args) throws InterruptedException  {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/");
        Thread.sleep(2000);
        WebElement search = (WebElement) driver.findElement(By.className("search__input"));
        search.sendKeys("Хорек");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement vitamins=driver.findElement(By.xpath("//a[contains(@title, 'Витамины Беафар ПАСТА Мальт с двойным действием для хорьков 100г')]"));
        vitamins.sendKeys(ENTER);
        Thread.sleep(2000);
        WebElement sravnenie=driver.findElement(By.xpath("//div[@id='comparison-product-8828-381']"));
        sravnenie.click();
        Thread.sleep(2000);
        WebElement search2 = driver.findElement(By.className("search__input"));
        search2.sendKeys("Медведь");
        Thread.sleep(2000);
        search2.sendKeys(ENTER);
        WebElement medved=driver.findElement(By.xpath("//a[contains(@title, 'Белый медведь 6х5х6см')]"));
        medved.sendKeys(ENTER);
        Thread.sleep(2000);
        WebElement sravnenie2=driver.findElement(By.xpath("//div[@id='comparison-product-14684-381']"));
        sravnenie2.click();
        Thread.sleep(2000);
        WebElement competion= driver.findElement(By.xpath("//div[@class='comparison-view']"));
        competion.click();
        Thread.sleep(2000);
        WebElement close= driver.findElement(By.xpath("//div[@class='compare-close j-close']"));
        close.click();
        Thread.sleep(2000);
        driver.quit();
    }

    }
