package HW2;
//1) Задание
//Написать программу, которая будет открывать пять различных страниц в новых окнах:
//    https://uhomki.com.ua/
//    https://zoo.kiev.ua/
//    https://www.w3schools.com/
//    https://taxi838.ua/ru/dnepr/
//    https://klopotenko.com/
//Прописать цикл, который будет переключаться поочередно через все страницы,
//для каждой страницы выводить в консоль название и ссылку на эту страницу.
//И будет закрывать ту страницу в названии которой есть слово зоопарк.
import HW2.Zadanie22.ExepensMethod;
import HW2.Zadanie33.*;
import HW2.Zadanie44.Picture;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Driver {
    public static void main(String[] args) throws InterruptedException, ZeroValID, ZeroValTagName,
            ZeroValClass, ZeroValName,ZeroValGetText {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       driver.get("https://uhomki.com.ua/");
        Thread.sleep(2000);
        Set<String> setFirst = driver.getWindowHandles(); //получаем идент.номер первого окна из множества открытых окон


        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setSecond = driver.getWindowHandles(); //получаем идент.номер второго окна из множества открытых окон
        setSecond.removeAll(setFirst);//убираем дубликаты
        String secondDesc = setSecond.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(secondDesc); //переключаемся на нужный дискриптор
        driver.get(" https://zoo.kiev.ua/");
        Thread.sleep(2000);


        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setThird = driver.getWindowHandles(); //получаем идент.номер третьего окна из множества открытых окон
        setThird.removeAll(setFirst);//убираем дубликаты
        setThird.removeAll(setSecond);//убираем дубликаты
        String thirdDesc = setThird.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(thirdDesc); //переключаемся на нужный дискриптор
        driver.get("https://www.w3schools.com/");
        Thread.sleep(2000);


        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setFourth = driver.getWindowHandles(); //получаем идент.номер четвертого окна из множества открытых окон
        setFourth.removeAll(setFirst);//убираем дубликаты
        setFourth.removeAll(setSecond);//убираем дубликаты
        setFourth.removeAll(setThird);//убираем дубликаты
        String fourthDesc = setFourth.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(fourthDesc); //переключаемся на нужный дискриптор
        driver.get("https://taxi838.ua/ru/dnepr/");
        Thread.sleep(2000);


        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setFifth = driver.getWindowHandles(); //получаем идент.номер пятого окна из множества открытых окон
        setFifth.removeAll(setFirst);//убираем дубликаты
        setFifth.removeAll(setSecond);//убираем дубликаты
        setFifth.removeAll(setThird);//убираем дубликаты
        setFifth.removeAll(setFourth);//убираем дубликаты
        String fifthDesc = setFifth.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(fifthDesc); //переключаемся на нужный дискриптор
        driver.get("https://klopotenko.com/");
        Thread.sleep(2000);

        driver.quit();
        Set<String> count = driver.getWindowHandles();
        Iterator<String> i = count.iterator();

        for (int k = 0; k < count.size(); k++) {
            i.hasNext();
            String childWindow = i.next();
            driver.switchTo().window(childWindow);
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            {
                if (driver.getTitle().toLowerCase().contains("зоопарк")) {
                    driver.close();
                }
            }

        }
        //////3 Задача
        driver.get("https://uhomki.com.ua/");
        Thread.sleep(2000);
        Method3 zero = new Method3();
        WebElement element = driver.findElement(By.id("special_offers_40cd750bba9870f18aada2478b24840a"));
        try {
            zero.methodZero(element);
        }catch (ZeroValID | ZeroValTagName | ZeroValClass | ZeroValName | ZeroValGetText exception){
            System.out.println(exception.getMessage());
        }
        /////4 Задача
        driver.get("https://uhomki.com.ua/");
        Thread.sleep(2000);
        Picture caktinka = new Picture();
        WebElement container = driver.findElement(By.xpath("//ul[contains(@class,'products-menu__container')]"));
        List<WebElement> footer = driver.findElements(By.xpath("//ul[@class='footer__menu']"));
        caktinka.methodPicture(container,footer);

        /////////2 Задача
        driver.get("https://uhomki.com.ua/");
        Thread.sleep(2000);
        ExepensMethod method1 = new ExepensMethod();
        WebElement first = driver.findElement(By.cssSelector(".favorites-view__button-text"));
        WebElement second = driver.findElement(By.cssSelector(".header-logo-img"));
        method1.exmethod(first,second);


    }


}

