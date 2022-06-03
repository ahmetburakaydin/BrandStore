package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ParentClass {

    protected WebDriver driver;
    protected WebDriverWait wait;



    public ParentClass(){
        driver=Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }


    public void openSite(String url){
        driver.get(url);
    }

    public void clickTo(By locater){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).click();
    }

    public void clickToPresence(By locater){
        wait.until(ExpectedConditions.presenceOfElementLocated(locater)).click();
    }

    public void clickTobeClickable(By locater){
        wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
    }

    public void clickTobeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void JSClickTo(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
    }
    public void sendkeysTo(By locater,String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(text);
    }

    public void sendkeysTo(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void hoverTo(WebElement element){
        new Actions(driver).moveToElement(element).pause(Duration.ofMillis(500)).build().perform();
    }



    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollIntoViewFalse(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",element);
    }

    public WebElement getElement(By locater){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
    }

    public List<WebElement> getListOfElements(By locater){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locater));

    }

    public String getText(By locater){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).getText();
    }

    public String getText(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public int getIntPrice(String price){
        return Integer.parseInt(((price.trim().split(" "))[1].split("\\.")[0]));
    }
    public int getIntStarPoint(String starText){
        String textReplace = starText.replaceAll("[^0-9.]","");
        String number = textReplace.split("\\.")[0];
        int num=0;
        if(!number.equals("0")) {
            num = Integer.parseInt(textReplace.split("\\.")[0]);
        }
        return num;

    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
