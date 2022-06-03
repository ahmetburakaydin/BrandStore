package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ComparisonPage extends ParentClass {

    public void addProductCompareList(){

        scrollIntoViewFalse(getElement(Locater.addtoCompareListLinkOnProductDisplayPage));
        clickTo(Locater.addtoCompareListLinkOnProductDisplayPage);

        sleep(2000);
        clickTo(By.cssSelector("button#cboxClose"));
        driver.navigate().back();


    }
    List<String> productNameList=new LinkedList<>();
    int randomProductIndex;
    int previousProductIndex;
    public void clickRandomProductOnAllCatagoriesForComparison() {
        List<WebElement> listOfProductsImages = getListOfElements(Locater.allProductImagesList);
        List<WebElement> listOfProductsNames = getListOfElements(Locater.productsNameMainPageList);

        randomProductIndex = new Random().nextInt(listOfProductsImages.size());

        productNameList.add(listOfProductsNames.get(randomProductIndex).getText());
        while(randomProductIndex!=previousProductIndex){

            clickTo(listOfProductsImages.get(randomProductIndex));
            previousProductIndex = randomProductIndex;

        }


    }


    public void clickSameProductonAllCatagoriesForComparison(){
        List<WebElement> listOfProductsImages = getListOfElements(Locater.allProductImagesList);
        List<WebElement> listOfProductsNames = getListOfElements(Locater.productsNameMainPageList);

        //randomProductIndex = new Random().nextInt(listOfProductsImages.size());
        /*if(!productNameList.contains(listOfProductsNames.get(randomProductIndex).getText())){
            productNameList.add(listOfProductsNames.get(randomProductIndex).getText());
        }*/


        clickTo(listOfProductsImages.get(randomProductIndex));
    }

    public void clickComparisonListLinkOnHeaderMenu(){

        String mainSiteId = driver.getWindowHandle();
        clickTo(Locater.comparisonListLinkOnHeaderMenu);
        Set<String>  allWindowHandles = driver.getWindowHandles();


        for (String windowHandle : allWindowHandles) {
            if(mainSiteId!=windowHandle){
                driver.switchTo().window(windowHandle);
            }
        }


    }
    String mainSiteId = driver.getWindowHandle();
    public void clickComparisonListLinkOnFooterMenu(){

        clickTo(Locater.comparisonListLinkOnFooterMenu);
        Set<String>  allWindowHandles = driver.getWindowHandles();


        for (String windowHandle : allWindowHandles) {
            if(mainSiteId!=windowHandle){
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public void validateProductNameOnComparisonList(int num){



        List<WebElement> listOfProductsName = getListOfElements(Locater.productsNameOnComparisonPage);
        for (WebElement element : listOfProductsName) {
            System.out.println(element.getText());
        }
        Assert.assertTrue(listOfProductsName.size()==num);
        driver.switchTo().window(mainSiteId);

    }

    public void  validateNoProductResultTextInComparisonList(){

        Assert.assertTrue(getElement(Locater.noProductsInComparisonListResultText).isDisplayed());
        driver.switchTo().window(mainSiteId);

    }

    public void  removeAllProductsFromComparisonList(){

        List<WebElement> listOfRemoveIcon2 = getListOfElements(Locater.removeIconsOnComparisonList);


        for (int i = 0; i < listOfRemoveIcon2.size(); i++) {
            driver.navigate().refresh();
            List<WebElement> listOfRemoveIcon = getListOfElements(Locater.removeIconsOnComparisonList);
            sleep(2000);
            clickTo(listOfRemoveIcon.get(0));
            sleep(2000);
        }

    }
}
