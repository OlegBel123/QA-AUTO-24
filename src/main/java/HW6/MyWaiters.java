package HW6;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class MyWaiters {
    private final WebDriver driver; //создаем драйвер

    public MyWaiters(WebDriver driver) {
        this.driver = driver;
    } //создаем конструктор класса

    private static final long EXPLICITY_WAIT = 20L;

    private FluentWait<WebDriver> fluentWait(Long duration) { //Метод fluentWait принимает в параметры Long duration
        return new FluentWait<>(driver)//возвращаем
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2)) //указываем время ожидания
                .ignoring(NoSuchElementException.class) //указываем классы
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    //Метод  принимает функцию
    private void waitForFunction(Function function, Long timeout) {
        FluentWait<WebDriver> wait = fluentWait(timeout);//приравниваем методы
        wait.until(function);
    }

    //Метод presenceOfElementLocated - Ожидание появления элемента расположенного по заданному локатору.
    public void waitpresenceOfElementLocated(By locator) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(locator), EXPLICITY_WAIT);
    }

    //Метод presenceOfElementLocatedReturn +
    public WebElement presenceOfElementLocatedReturn(By locator) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Метод textToBePresentInElementValue() - Ожидание появления текста в элементе.
    public void waittextToBePresentInElementValue(By locator, String text) {
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(locator, text), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waittextToBePresentInElementValue(WebElement element, String text) {
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(element, text), EXPLICITY_WAIT);
    }
    //Метод invisibilityOf() - Ожидание видимости элемента
    public void waitinvisibilityOf(WebElement element) {
        waitForFunction(ExpectedConditions.invisibilityOf(element), EXPLICITY_WAIT);
    }

    //Метод titleContains() - Ожидание что в названии странице находится указанный текст.
    public void waittitleContains(String text) {
        waitForFunction(ExpectedConditions.titleContains(text), EXPLICITY_WAIT);
    }

    //Метод titleIs() - Ожидание указанного названия страницы.
    public void waittitleIs(String expectedTitle) {
        waitForFunction(ExpectedConditions.titleIs(expectedTitle), EXPLICITY_WAIT);
    }

    //Метод elementToBeClickable() - Ожидание кликабельности элемента.
    public void waitElementToBeClickable(By locator) {
        waitForFunction(ExpectedConditions.elementToBeClickable(locator), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitElementToBeClickable(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeClickable(element), EXPLICITY_WAIT);

    }
    //Метод elementToBeClickable()+
    public WebElement waitElementToBeClickableReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }
    //Перегруз
    public WebElement waitElementToBeClickableReturn(By locator ) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(locator));
    }
    //=Метод elementToBeSelected() - Ожидание чтобы элемент был выбран.
    public void waitElementToBeSelected(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeSelected(element), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitElementToBeSelected(By locator) {
        waitForFunction(ExpectedConditions.elementToBeSelected(locator), EXPLICITY_WAIT);
    }
    //Метод elementSelectionStateToBe() - Ожидание от элемента быть или не быть выбранным.
    public void waitElementStateToBe(WebElement element, boolean boo) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, boo), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitElementStateToBe(By locator, boolean boo) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(locator, boo), EXPLICITY_WAIT);
    }
    //Метод visibilityOfElementLocated() - Ожидание видимости элемента.
      public void waitForVisibilityOfElementLocated(By locator) {
          waitForFunction(ExpectedConditions.visibilityOfElementLocated(locator),EXPLICITY_WAIT);
    }
    public WebElement waitForVisibilityOfElementLocatedReturn(By locator) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Метод frameToBeAvailableAndSwitchToIt() - Ожидание доступности фрейма и переключение на него.
    public void waitframeToBeAvailableAndSwitchToIt(By frameLocator) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator), EXPLICITY_WAIT);
    }
    //
    public void waitframeToBeAvailableAndSwitchToIt(String text) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(text), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitframeToBeAvailableAndSwitchToIt(WebElement element) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitframeToBeAvailableAndSwitchToIt(int integer) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(integer), EXPLICITY_WAIT);
    }
    //Метод alertIsPresent() - Ожидает появления алерта и возвращает его.
    public void waitalertIsPresent(){
        waitForFunction(ExpectedConditions.alertIsPresent(), EXPLICITY_WAIT);
    }

}