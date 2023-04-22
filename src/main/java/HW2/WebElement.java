package HW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.zip.ZipEntry;

//Задание 2.
//Написать метод в параметры которого принимаются два ВебЭлемента.
// метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
// какой из элементов располагается левее на странице, а также какой из элементов занимает большую площадь.
// Параметры метода могут также включать в себя другие аргументы, если это необходимо.
public class WebElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Какой из элементов занимает большую площадь
        driver.get("https://uhomki.com.ua/");
        Thread.sleep(200);
        org.openqa.selenium.WebElement first = driver.findElement(By.cssSelector(".favorites-view__button-text"));
        org.openqa.selenium.WebElement second = driver.findElement(By.cssSelector(".header-logo-img"));
        //площадь
        int S1 = first.getSize().height*first.getSize().width;
        int S2 = second.getSize().height*second.getSize().width;
        if (S1>S2){
            System.out.println("Площадь S1 больше = " +S1);
        }
        else {
            System.out.println("Площадь S2 больше = " +S2);
        }



    }



    }


