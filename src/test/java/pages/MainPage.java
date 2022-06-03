package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;
import static utils.Logger1.*;

import java.util.List;

public class MainPage extends ParentClass {


    public void gotoWebSite(){
        openSite(Locater.url);
       //getLogger().info("user on home page");

    }

    public void gotoHomePage(){
        clickTo(Locater.homeButtonMainMenuBar);
    }

    public void validateAllImagesOnMainPage (){
        List<WebElement> listOfProductImages = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locater.mainPageProductImages));
        for (int i = 0; i < listOfProductImages.size(); i++) {
            scrollIntoView(listOfProductImages.get(i));
            Assert.assertTrue(listOfProductImages.get(i).isDisplayed());
        }


    }


}
