package HW7;

import HW5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

//Task4:
//Открыть сайт https://www.guinnessworldrecords.com/Account/Login. Написать тест, проверяющий что изначально чек-бокс “RememberMe” не выбран.
// Потом кликнуть на него и реализовать проверку того, что он выбран. После снова нажать на чек-бокс и проверить что он снова не выбран.
public class Task4 {
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://www.guinnessworldrecords.com/Account/Login");// открытие страницы
        driver.manage().window().maximize();
    }
    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
    @Test
    public void Test4rememberMe(){
        //input[@id='RememberMe']
       MyWaiters exempClassa = new MyWaiters(driver);
        Actions actions = new Actions(driver);
        WebElement checkBox= driver.findElement(By.xpath("//input[@id='RememberMe']"));
        exempClassa.waitelementSelectionStateToBe((By) checkBox,false);
        assertTrue(checkBox.isSelected()==false,"Чекбокс выбран");
        exempClassa.waitElementSelectionStateToBe(checkBox,true);
        assertTrue(checkBox.isSelected()==true,"Чекбокс не выбран");
        exempClassa.waitElementSelectionStateToBe(checkBox,false);
        assertTrue(checkBox.isSelected()==false,"Чекбокс выбран");


        }


    }






