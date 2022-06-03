package pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;
import java.util.Random;

public class RecentlyViewedPage extends ParentClass {
    String firstProductName ;
    String secondProductName ;

    public void displayTwoProducts(){

        List<WebElement> listOfProductsImages = getListOfElements(Locater.allProductImagesList);


        int randomIndex= new Random().nextInt(listOfProductsImages.size());

        clickTo(listOfProductsImages.get(randomIndex));
        sleep(1000);
        firstProductName = getText(Locater.productNameOnDisplayPage);
        driver.navigate().back();

        int randomIndex2=new Random().nextInt(listOfProductsImages.size());
        listOfProductsImages = getListOfElements(Locater.allProductImagesList);
        clickTo(listOfProductsImages.get(randomIndex2));
        secondProductName = getText(Locater.productNameOnDisplayPage);

        clickTo(Locater.mainMenuAlleProdukteLink);

    }

    public void validateProductNamesOnRecentlyViewedSection(){

        List<WebElement> productsNameRecentlyViewed = getListOfElements(Locater.productNameOnRecentlyViewedPage);
        for (int i = 0; i < productsNameRecentlyViewed.size(); i++) {
            productsNameRecentlyViewed = getListOfElements(Locater.productNameOnRecentlyViewedPage);
            Assert.assertTrue(productsNameRecentlyViewed.get(i).getText().trim().equalsIgnoreCase(firstProductName) ||
                    productsNameRecentlyViewed.get(i).getText().trim().equalsIgnoreCase(secondProductName) );

        }


    }
}
