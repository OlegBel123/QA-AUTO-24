package HW5;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Discriptors {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.get("https://www.google.com/search");//Вводим в поисковую строку 1 ссылку
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        WebElement searchField = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchField.sendKeys("https://www.guinnessworldrecords.com/account/register?");//Вводим в поисковую строку 2 ссылку
        searchField.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//h3[text()='Create account | Guinness World Records']"));
        WebElement firstPage = driver.findElement(By.xpath("//h3[text()='Create account | Guinness World Records']"));
        Set<String> firstWindows = driver.getWindowHandles();
        actions.moveToElement(firstPage).keyDown(Keys.CONTROL).click(firstPage).keyUp(Keys.CONTROL).build().perform();
        Set<String> secondWindows = driver.getWindowHandles();
        secondWindows.removeAll(firstWindows);
        String secondWindowHandle = secondWindows.iterator().next();
        WebElement searchField2 = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchField2.clear();
        searchField2.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");//Вводим в поисковую строку 3 ссылку
        searchField2.sendKeys(Keys.ENTER);
        Set<String> firstWindowsUp = driver.getWindowHandles();
        WebElement secondPage = driver.findElement(By.xpath("//h3[text()='AlertsDemo - H Y R Tutorials']"));
        actions.moveToElement(secondPage).keyDown(Keys.CONTROL).click(secondPage).keyUp(Keys.CONTROL).build().perform();
        Set<String> secondWindowsUp = driver.getWindowHandles();
        secondWindowsUp.removeAll(firstWindowsUp);
        String thirdWindowHandle = secondWindowsUp.iterator().next();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");//Вводим в поисковую строку 4 ссылку
        Thread.sleep(2000);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(3000);
        //input[@name='fname'] First name
        //input[@id='lname'] Last name
        //input[@type='submit'] Submit
        WebElement fname = driver.findElement(By.xpath("//input[@name='fname']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@id='lname']"));
        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        fname.clear();
        fname.sendKeys("Nina");
        lastname.clear();
        lastname.sendKeys("Levchuk");
        submitBtn.click();
        Thread.sleep(3000);
        System.out.println(driver.findElements(By.xpath("//p")).get(1).getText());
        driver.switchTo().window(secondWindowHandle);
        //input[@id='LastName']
        //input[@id='LastName']
        //input[@id='FirstName']
        //input[@id='DateOfBirthDay']
        //input[@id='DateOfBirthMonth']
        //input[@id='DateOfBirthYear']
        driver.findElement(By.xpath("//input[@id='LastName']"));
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Levchuk");
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Nina");
        driver.findElement(By.xpath("//input[@id='DateOfBirthDay']")).sendKeys("01");
        driver.findElement(By.xpath("//input[@id='DateOfBirthMonth']")).sendKeys("03");
        driver.findElement(By.xpath("//input[@id='DateOfBirthYear']")).sendKeys("1987");
        Select select1= new Select(driver.findElement(By.xpath("//select[@id='Country']")));
        select1.selectByVisibleText("Ukraine");
        Thread.sleep(4000);
        //input[@class='input-large create-application-name']
        driver.findElement(By.xpath("//input[@class='input-large create-application-name']"));
        WebElement countryField = driver.findElement
                (By.xpath("//input[@class='input-large create-application-name']"));
        countryField.sendKeys("Zaporozhye");
        //input[@id='EmailAddress']
        //input[@id='ConfirmEmailAddress']
        //input[@id='Password']
        //input[@id='ConfirmPassword']
        driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("gmail@mail.com");
        driver.findElement(By.xpath("//input[@id='ConfirmEmailAddress']")).sendKeys("gmail@mail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("555555555");
        WebElement confirmPass = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPass.sendKeys("555555");
        confirmPass.sendKeys(Keys.ENTER);
        driver.findElement (By.xpath("//span[@for='ConfirmPassword']"));
        System.out.println(driver.findElement(By.xpath("//span[@for='ConfirmPassword']")).getText());
        driver.switchTo().window(thirdWindowHandle);
        //button[@id='alertBox']//клик
        //button[@id='alertBox']
        driver.findElement(By.xpath("//button[@id='alertBox']"));
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='alertBox']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alertbox = wait.until(ExpectedConditions.alertIsPresent());
        alertbox.accept();
        Thread.sleep(4000);
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());
        driver.findElement(By.xpath("//button[@id='confirmBox']")).click();
        Alert confirmbox = wait.until(ExpectedConditions.alertIsPresent());
        confirmbox.dismiss();
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//button[@id='promptBox']")).click();
        Alert promtBox = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(4000);
        promtBox.sendKeys("\'Final step of this task\'");
        promtBox.accept();
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());
        Thread.sleep(4000);
        driver.quit();

    }}


