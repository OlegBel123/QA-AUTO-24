import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson0 {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/default.asp");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Continue with Recommended Cookies']"))
                .click();
        System.out.println(driver.findElement(By.linkText("Apple now")).getText());


    }
}
