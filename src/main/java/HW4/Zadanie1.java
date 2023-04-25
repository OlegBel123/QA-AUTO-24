package HW4;
//1) http://only-testing-blog.blogspot.com/2014/01/textbox.html?
//Написать программу реализующую действие показанное на "видео1.mp4".
//После выполнения программы на консоли должна выводится информация в следующем виде:
//
//Автомобили доступные для выбора:
//Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
//Страны из первой таблицы:
//USA, Russia, Japan, Mexico, India, Malaysia, Greece.
//Страны из второй таблицы:
//France, Germany, Italy, Spain.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.Keys.DOWN;

public class Zadanie1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        WebElement carElement = driver.findElement(By.id("Carlist"));//создаем класс WebElement
        carElement.click();
        carElement.sendKeys(DOWN);
        carElement.sendKeys(DOWN);
        carElement.sendKeys(DOWN);
        carElement.sendKeys(DOWN);
        carElement.sendKeys(DOWN);
        WebElement car = driver.findElement(By.id("car6"));
        car.click();

        WebElement cantry = driver.findElement(By.xpath("//select[@name='FromLB']"));
        Select cantrySelect = new Select(cantry);// создаем объект класса Select, в конструктор помещаем созданный елемент (carElement).
        cantrySelect.selectByIndex(2);
        cantrySelect.selectByValue("India");
        cantrySelect.deselectByValue("India");
        cantrySelect.selectByValue("Germany");
        cantrySelect.selectByValue("Italy");
        cantrySelect.selectByValue("Malaysia");
        cantrySelect.deselectByValue("Malaysia");
        cantrySelect.selectByValue("Spain");
        WebElement addElement = driver.findElement(By.xpath("//input[@value='->']"));
        addElement.click();

        System.out.println("Авто доступные к заказу:" +carElement.getText());
        System.out.println("Страны из первой таблицы: ");
        List<WebElement> cantris = cantrySelect.getOptions();
        for (WebElement contr : cantris){
            System.out.println(contr.getText() + " ");

        }
        System.out.println("Страны из второй таблицы:  ");
        WebElement con = driver.findElement(By.xpath("//select[@name='ToLB']"));
        Select cantSelect = new Select(con);
        List<WebElement> cons = cantSelect.getOptions();
        for (WebElement contru : cons){
            System.out.println(contru.getText());
        }





    }
}