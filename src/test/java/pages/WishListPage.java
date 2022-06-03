package pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;
import java.util.Random;

public class WishListPage extends ParentClass {
    String productName;
    String productName2;

    public void clickHeartIconOnProductImageOnMainPage() {
        List<WebElement> listOfHeartIcon = getListOfElements(Locater.heartIconsMainPageList);

        List<WebElement> listOfProductsName = getListOfElements(Locater.productsNameMainPageList);
        int randomNum = new Random().nextInt(listOfHeartIcon.size());
        productName = getText(listOfProductsName.get(randomNum)).trim();
        clickTo(listOfHeartIcon.get(randomNum));
        sleep(2000);

    }

    public void validateProductNameOnWishList() {
        List<WebElement> listofNamesOnWistList = getListOfElements(Locater.productNamesOnWishListList);

        for (int i = 0; i < listofNamesOnWistList.size(); i++) {
            String wishProduct = listofNamesOnWistList.get(i).getText().trim();
            if (wishProduct.equals(productName)) {
                Assert.assertEquals(wishProduct, productName);

            }
        }

        productName=null;


    }

    public void clickRandomProductOnAllProductsPage() {
        List<WebElement> listOfProductsImages = getListOfElements(Locater.allProductImagesList);
        List<WebElement> listOfProductsNames = getListOfElements(Locater.productsNameMainPageList);
        List<WebElement> listOfProducts = driver.findElements(Locater.productsTextsOnImages);
        int randomProductIndex = new Random().nextInt(listOfProductsImages.size());
        productName = listOfProductsNames.get(randomProductIndex).getText();

        int randomTemp = 0;
        while (listOfProducts.get(randomProductIndex).getText().toLowerCase().contains("ausverkauft")) {

            do {
                randomTemp = new Random().nextInt(listOfProducts.size());

            } while (randomProductIndex == randomTemp);

            randomProductIndex = randomTemp;
        }

        clickTo(listOfProductsImages.get(randomProductIndex));
    }







    public void  clickRandomProductsHeartIconOnAllProductsPage(){

        List<WebElement> listOfHeartIconofAllProducts = getListOfElements(Locater.heartIconsAllCatagoriesPageList);
        List<WebElement> listOfProductsNames = getListOfElements(Locater.productsNameAllCatagoriesPageList);
        int randomHeartIconIndex = new Random().nextInt(listOfHeartIconofAllProducts.size());
        productName = listOfProductsNames.get(randomHeartIconIndex).getText();

        JSClickTo(listOfHeartIconofAllProducts.get(randomHeartIconIndex));

        sleep(3000);


    }

    public void clickSameProductHeartBeatIconOnAllProductsPage(){

        clickTo(getElement(Locater.heartBeatIconAfterClickinHeartIcon));


    }

    public void clickSimilarProductsHeartIconRandomly() {
        List<WebElement> listOfHeartIcon = getListOfElements(Locater.similarProductsHeartIconOnDisplayPage);
        List<WebElement> listOfProductsName = getListOfElements(Locater.productsNameMainPageList);
        int randomNum = new Random().nextInt(listOfHeartIcon.size());
        productName = getText(listOfProductsName.get(randomNum)).trim();
        clickTo(listOfHeartIcon.get(randomNum));
        sleep(2000);
        clickTo(Locater.productHeartBeatIconLink);
        sleep(2000);
    }



    public void addWishListOnProductDisplayPage() {
        scrollIntoViewFalse(getElement(Locater.productDisplayPageAddtoWishListLink));

        sleep(2000);
        clickTo(Locater.productDisplayPageAddtoWishListLink);
        sleep(2000);


    }

    public void validateProductNameOnWishList2() {
        List<WebElement> listofNamesOnWistList = getListOfElements(Locater.productNamesOnWishListList);

        for (int i = 0; i < listofNamesOnWistList.size(); i++) {
            String wishProduct = listofNamesOnWistList.get(i).getText().trim();
            if (wishProduct.equals(productName)) {
                Assert.assertEquals(wishProduct, productName);

            }
        }


    }

    public void clickHeartIconTwoTimesOnProductImageOnMainPage() {
        List<WebElement> listOfHeartIcon = getListOfElements(Locater.heartIconsMainPageList);

        List<WebElement> listOfProductsName = getListOfElements(Locater.productsNameMainPageList);
        int randomNum = new Random().nextInt(listOfHeartIcon.size());
        productName = getText(listOfProductsName.get(randomNum)).trim();
        clickTo(listOfHeartIcon.get(randomNum));
        sleep(2000);
        clickTo(Locater.productHeartBeatIconLink);
        sleep(2000);
    }



    public void gotoWishListFromFooterMenu() {
        scrollIntoView(getElement(Locater.wishListOnFooterMenuLink));
        clickTo(Locater.wishListOnFooterMenuLink);
        sleep(2000);
    }

    public void gotoWishListFromHeaderMenu() {
        clickTo(Locater.wishListOnHeadMenuLink);
    }

    public void removeAllProductFromWishList() {
        List<WebElement> listOfRemoveIcons = getListOfElements(Locater.allRemoveIconsOnWishList);

        for (WebElement icon : listOfRemoveIcons) {
            clickTo(icon);
            sleep(1000);
        }
    }

    public void validateNoProductsInWishList(){

        String expectedText = "Keine Produkte zur Wunschliste hinzugefügt!";
        System.out.println(expectedText);
        System.out.println(getElement(Locater.noProductResultTextOnWishList).getText());
        Assert.assertEquals(getElement(Locater.noProductResultTextOnWishList).getText(),expectedText.trim());


    }
    public void userClicksRandomProductFromAllProductsPage(){





    }

    public void gotoWishListFromSelectedLink(String menu){
        switch (menu.toLowerCase()){
            case "header" : {
                clickTo(Locater.wishListOnHeadMenuLink);
                break;
            }
            case "footer" : {
                //scrollIntoView(getElement(Locater.wishListOnFooterMenuLink));
                clickTo(Locater.wishListOnFooterMenuLink);
                break;
            }
            case "display page" :  {
                clickTo(Locater.productPageViewWishlistLink);
                break;
            }
            case "heartbeat" : {
                hoverTo(getElement(Locater.heartBeatIconAfterClickinHeartIcon));
                clickTo(Locater.heartBeatIconAfterClickinHeartIcon);
                break;
            }
        }
    }





}
