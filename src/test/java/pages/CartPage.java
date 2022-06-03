package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CartPage extends ParentClass {

    List<String> productNames = new LinkedList<>();

    public void addProductToCartOnMainPage(int count) {

        List<WebElement> listOfProductName;


        for (int i = 0; i < count; i++) {
            List<WebElement> listOfAddToCartButton = getListOfElements(Locater.addtoCartButtonOnMainPage);
            List<WebElement> listOfProducts = driver.findElements(By.cssSelector("a[class$='woocommerce-loop-product__link']"));

            listOfProductName = getListOfElements(Locater.productsNameMainPageList);

            int randomIndex = new Random().nextInt(listOfAddToCartButton.size());
            int randomTemp = 0;

            while (listOfProducts.get(randomIndex).getText().toLowerCase().contains("ausverkauft")) {

                do {
                    randomTemp = new Random().nextInt(listOfProducts.size());

                } while (randomIndex == randomTemp);

                randomIndex = randomTemp;
            }


            if (listOfAddToCartButton.get(randomIndex).getText().equals("In den Warenkorb")) {

                productNames.add(listOfProductName.get(randomIndex).getText());
                scrollIntoViewFalse(listOfAddToCartButton.get(randomIndex));
                //String text = listOfProductName.get(randomIndex).getText();
                clickTobeClickable(listOfAddToCartButton.get(randomIndex));
                //getLogger().info(" PRODUCT : '"+text+"' is clicked");
                sleep(3000);



            } else {
                productNames.add(listOfProductName.get(randomIndex).getText());
                scrollIntoViewFalse(listOfAddToCartButton.get(randomIndex));
                sleep(1000);
                //String text = listOfProductName.get(randomIndex).getText();
                clickTo(listOfAddToCartButton.get(randomIndex));
               // getLogger().info(" PRODUCT : '"+text+"' is clicked");
                sleep(2000);

                Select select = new Select(getElement(Locater.productDisplaySizeSelect));
                int randomSelectNum = new Random().nextInt(select.getOptions().size());
                //String text2= select.getOptions().get(randomSelectNum).getText();
                select.selectByIndex(randomSelectNum);
                //getLogger().info("selected product size "+ text2);
                sleep(3000);
                clickTo(Locater.addtoCartButtonOnDisplayPage);
                //getLogger().info("product added to cart");
                sleep(3000);
            }

        }


    }
    public void clickMainCartonMenu (String menu){

        switch (menu){

            case "footer" :
                sleep(2000);
                clickTo(Locater.mainCartPageLinkOnFooterMenu);
                //getLogger().info("user went to main cart via footer menu link");
                sleep(2000);
                break;
            case "mini cart" :
                sleep(2000);
                clickTo(Locater.miniCartIcoOnHeaderMenu);
                //getLogger().info("user went to main cart via mini cart menu link");
                sleep(2000);
                break;
            case "header" :
                sleep(2000);
                hoverTo(getElement(Locater.mainCartPageIconOnHeaderMenuBar));
                JSClickTo(getElement(Locater.mainCartPageIconOnHeaderMenuBar));
                //getLogger().info("user went to main cart via header menu link");
                sleep(2000);

        }


    }


    public void validateProductNamesOnMainCartPage() {
        List<WebElement> mainCartProductNames = getListOfElements(By.cssSelector("tr.woocommerce-cart-form__cart-item.cart_item td:nth-of-type(3) a"));
        for (WebElement name : mainCartProductNames) {
            mainCartProductNames = getListOfElements(By.cssSelector("tr.woocommerce-cart-form__cart-item.cart_item td:nth-of-type(3) a"));
            //String text=name.getText();
            for (String productName : productNames) {

                if (name.getText().toLowerCase().contains(productName.toLowerCase())) {
                    Assert.assertTrue(name.getText().toLowerCase().contains(productName.toLowerCase()));
                    //getLogger().info("ASSERTION : Actual Text = "+text+"Expected Text = "+productName);
                }
            }

        }
        productNames = new LinkedList<>();

    }

    String productName;
    int randomProductIndex;

    List<String> productNames2 = new LinkedList<>();

    public void clickProductOnAllProductsAndAddToCart(int count) {


        for (int i = 0; i < count; i++) {
            List<WebElement> listOfProductsImages = getListOfElements(Locater.allProductImagesList);
            List<WebElement> listOfProductsNames = getListOfElements(Locater.productsNameMainPageList);
            List<WebElement> listOfProducts = driver.findElements(Locater.productsTextsOnImages);

            randomProductIndex = new Random().nextInt(listOfProductsImages.size());
            int randomTemp = 0;
            while (listOfProducts.get(randomProductIndex).getText().toLowerCase().contains("ausverkauft")) {

                do {
                    randomTemp = new Random().nextInt(listOfProducts.size());

                } while (randomProductIndex == randomTemp);

                randomProductIndex = randomTemp;
            }


            System.out.println(randomProductIndex + " random sayi");
            productNames.add(listOfProductsNames.get(randomProductIndex).getText());
            scrollIntoViewFalse(listOfProductsImages.get(randomProductIndex));
            //String text=listOfProductsNames.get(randomProductIndex).getText();
            clickTo(listOfProductsImages.get(randomProductIndex));
            //getLogger().info("product "+text+" is clicked");
            sleep(2000);

            scrollIntoViewFalse(getElement(Locater.eigenschaftenLink));
            clickTo(Locater.eigenschaftenLink);

            if (getText(Locater.eigenschaftenSizeText).contains("Onesize")) {
                sleep(1000);
                //String text2=listOfProductsNames.get(randomProductIndex).getText();
                clickTo(Locater.addtoCartButtonOnDisplayPageWithoutSelection);
                //getLogger().info(" product "+text2+" is clicked");
                sleep(3000);

            } else if (!getText(Locater.eigenschaftenSizeText).contains("Onesize")) {
                Select select = new Select(getElement(Locater.productDisplaySizeSelect));
                int randomIndex = new Random().nextInt(select.getOptions().size());
                select.selectByIndex(randomIndex);
                sleep(2000);
                //String text2= listOfProductsNames.get(randomProductIndex).getText();
                clickTo(Locater.addtoCartButtonOnDisplayPage);
                //getLogger().info(" product "+text2+" is clicked");
                sleep(2000);
                clickTo(Locater.addtoCartButtonOnDisplayPageWithoutSelection);
            }

            driver.navigate().back();

        }


    }

    public void clickProductOnAllCatagoriesAndAddToCartGoesToMainCartFromDisplayPage() {
        List<WebElement> listOfProductsImages = getListOfElements(Locater.allProductImagesList);
        List<WebElement> listOfProductsNames = getListOfElements(Locater.productsNameMainPageList);

        randomProductIndex = new Random().nextInt(listOfProductsImages.size());
        productNames.add(listOfProductsNames.get(randomProductIndex).getText());

        scrollIntoViewFalse(listOfProductsImages.get(randomProductIndex));
        //String text =listOfProductsNames.get(randomProductIndex).getText();
        clickTo(listOfProductsImages.get(randomProductIndex));
        //getLogger().info(" product "+text+" is clicked");
        scrollIntoViewFalse(getElement(Locater.eigenschaftenLink));
        clickTo(Locater.eigenschaftenLink);


        if (getText(Locater.eigenschaftenSizeText).contains("Onesize")) {
            sleep(1000);
            clickTo(Locater.addtoCartButtonOnDisplayPageWithoutSelection);
            sleep(3000);
        } else if (!getText(Locater.eigenschaftenSizeText).contains("Onesize")) {

            Select select = new Select(getElement(Locater.productDisplaySizeSelect));

            select.selectByIndex(new Random().nextInt(select.getOptions().size()));
            sleep(2000);
            clickTobeClickable(Locater.addtoCartButtonOnDisplayPage);
            sleep(2000);
            clickTo(Locater.addtoCartButtonOnDisplayPageWithoutSelection);

        }

        clickTo(Locater.mainCartLinkOnDisplayPage);

    }

    public void updateAllProductQuantitiesOnMainCart() {

        List<WebElement> listOfCurrentQuantity1 = getListOfElements(By.cssSelector("div.quantity.buttons_added input"));


        for (int i = 0; i < listOfCurrentQuantity1.size(); i++) {

            List<WebElement> listOfCurrentQuantity = getListOfElements(By.cssSelector("div.quantity.buttons_added input"));
            List<WebElement> listOfPlusIcon = getListOfElements(By.cssSelector("div.quantity.buttons_added a#plus_qty"));
            List<WebElement> listOfMinusIcon = getListOfElements(By.cssSelector("div.quantity.buttons_added a#minus_qty"));
            //String text= listOfCurrentQuantity.get(i).getText();
            if (listOfCurrentQuantity.get(i).getAttribute("value").equals("1")) {

                clickTo(listOfPlusIcon.get(i));

                clickTo(getElement(By.cssSelector("button[name='update_cart']")));
                sleep(4000);

            } else {
                sleep(1000);
                clickTo(listOfMinusIcon.get(i));
                sleep(1000);
                clickTo(getElement(By.cssSelector("button[name='update_cart']")));
                sleep(1000);

            }
            //getLogger().info((i+1)+".product "+text+" is clicked");
        }
        sleep(2000);
        //getLogger().info("main cart product's quantities updated");

    }


    public void validateNewQuantityAfterUpdatingCart() {

        Assert.assertTrue(getElement(By.cssSelector("div.woocommerce-message")).isDisplayed());
        //getLogger().info("ASSERTION : 'Cart updated' text is displayed");


    }

    public void removeAllProductsFromMainCart() {

        List<WebElement> listOfRemoveIcon2 = getListOfElements(By.cssSelector("td.product-remove a"));
        for (int i = 0; i < listOfRemoveIcon2.size(); i++) {
            List<WebElement> listOfRemoveIcon = getListOfElements(By.cssSelector("td.product-remove a"));
            clickTo(listOfRemoveIcon.get(0));
            sleep(3000);
            Assert.assertTrue(getText(By.cssSelector("div.woocommerce-message a")).contains("Rückgängig?"));

        }
        //getLogger().info("products removed from main cart");

    }

    public void validateEmptyCartAfterRemovingAllProduct() {

        Assert.assertEquals(getText(By.cssSelector("p.cart-empty.woocommerce-info")), "Ihr Warenkorb ist gegenwärtig leer.");
        //getLogger().info("ASSERTION : 'Your shopping cart is currently empty' text is displayed");
    }
}
