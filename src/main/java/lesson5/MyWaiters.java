package lesson5;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class MyWaiters {
    // ожидания работают с драйвером поэтому создадим драйвер
    private final WebDriver driver;
    //создадим конструктор класса их его принимающие параметры
    public MyWaiters(WebDriver driver){
        this.driver = driver;
    }

    private static final long EXPLICITY_WAIT=20L; //значение наших ожиданий

    //далее создаем метод кот.возвращает экземпляр свободного ожидания

    private FluentWait<WebDriver> fluentWait(Long duration){//метод fluentWait принимает в параметры Long duration
        return new FluentWait<>(driver)//возвращаем
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    //создаем метод окторый будет ожидать функцию
    private void waitForFunction(Function function,Long timeout){
        FluentWait<WebDriver> wait = fluentWait(timeout);//прировняли два метода
        wait.until(function);
    }
//создаем локатор с параметрами Ву ву
    public void waitForVisabilityOfElement(By by){
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by),EXPLICITY_WAIT);
    }
//создаем метод который будет возвращать вебэлемент
    public WebElement waitForVisabilityOfElementReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
//создаем метод который будет ожидать появление фрайма и переключаться на него
    public void waitForFrameAndSwitchToIt(By by){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by),EXPLICITY_WAIT);
    }
//создаем метод который будет ожидать алерт и возвращать его
    public Alert waitForAlertAndSwitchToIt(){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }
//создаем метод waitElementToBeClickable кот. будет ожидать чтобы эл.стал кликабельным с принимающими параметрами (поиск локатора)
    public void waitElementToBeClickable(By by){
        waitForFunction(ExpectedConditions.elementToBeClickable(by),EXPLICITY_WAIT);
    }
    //перегружаем уже существ. метод waitElementToBeClickable с приним.параметрами вебэлемент
    public void waitElementToBeClickable(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeClickable(element),EXPLICITY_WAIT);
    }
    //создаем метод waitElementToBeSelected с принимающими параметрами - поиск локатора
    public void waitElementToBeSelected(By by){
        waitForFunction(ExpectedConditions.elementToBeSelected(by),EXPLICITY_WAIT);
    }
    //перегружаем уже сущ-ий метод waitElementToBeSelected с новыми приним.пар-ми вебэлемент
    public void waitElementToBeSelected(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeSelected(element),EXPLICITY_WAIT);
    }
    //создаем метод waitElementStateToBe с приним.пар-ми вебэлемент и булеон значением
    public void waitElementStateToBe(WebElement element, boolean boo){
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element,boo),EXPLICITY_WAIT);
    }
    //создаем метод waitVisabilityOfWebElent с принимающими пар-ми вебэлемент
    //этот метод работает только с вебэлементом а дальше он ждет функцию
    public void waitVisabilityOfWebElent(WebElement element){
        waitForFunction(ExpectedConditions.visibilityOf(element),EXPLICITY_WAIT);
    }
    //перегружаем сущ.метод waitVisabilityOfWebElent с приним.параметрами - поиск локатора
    //мы поменяли на приним.пар-р локатор но внутри метода указали функцию кот.ищет элемент через локатор
    public void waitVisabilityOfWebElent(By by){
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)),EXPLICITY_WAIT);
    }

    //создаем метод waitVisabilityOfWebElentReturn с приним.пар-ми вэбэлемента
    //внутри возвращает вебэлемент
    public WebElement waitVisabilityOfWebElentReturn(WebElement element){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }
    //перегружаем метод waitVisabilityOfWebElentReturn с приним.пар-ми - поиск локатора
    //внутри возвращаем элемент но который ищем через локатор
    public WebElement waitVisabilityOfWebElentReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
}
