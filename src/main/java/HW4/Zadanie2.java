package HW4;
//2) http://www.ashortjourney.com/
//Написать программу, которая будет автоматизировать сценарий показанный на видео "Сценарий для автоматизии.mp4".
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadanie2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        driver.get("http://www.ashortjourney.com/");
        Thread.sleep(7000);
        //1
        // [stroke-width='4']
        //[r='8']
        WebElement bigCircle=driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement smallCircle= driver.findElement(By.cssSelector("[r='8']"));
        //actions.dragAndDrop(bigCircle,smallCircle).perform();// 1 var
        int x=bigCircle.getLocation().x+(bigCircle.getSize().width/2);
        int y=bigCircle.getLocation().y+(bigCircle.getSize().height/2);
        int x2=smallCircle.getLocation().x+(smallCircle.getSize().width/2);
        int y2=smallCircle.getLocation().y+(smallCircle.getSize().height/2);
        actions.moveByOffset(x,y).clickAndHold().moveByOffset(x2,y2).release().build().perform();//2 var
        Thread.sleep(9000);
        //2
        //[r='40']
        //[r='8']
        WebElement three=driver.findElement(By.cssSelector("[r='40']"));
        WebElement fourCircle= driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(three,fourCircle).release().build().perform();
        Thread.sleep(8000);
        //3
        //[font-weight='600']
        //[r='8']
        WebElement fif=driver.findElement(By.cssSelector("[font-weight='600']"));
        WebElement six= driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(fif,six).release().build().perform();
        Thread.sleep(8000);
        //4
        //[r='40']
        //[r='8']
        WebElement seven=driver.findElement(By.cssSelector("[r='40']"));
        WebElement eight = driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(seven,eight).release().build().perform();
        Thread.sleep(8000);
        //5
        //[stroke-width='4']
        //[r='8']
        WebElement nine=driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement ten = driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(nine,ten).release().build().perform();
        Thread.sleep(8000);
        //6
        //[stroke-width='4']
        //[r='8']
        WebElement elev=driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement twel = driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(elev,twel).release().build().perform();
        Thread.sleep(8000);
        //7
        //[stroke-width='4']
        //[r='8']
        //[cy ='177']
        WebElement thirteen=driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement fourteen = driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(thirteen,fourteen).release().build().perform();
        Thread.sleep(8000);
        //driver.quit();




    }}