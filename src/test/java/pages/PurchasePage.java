package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;

public class PurchasePage extends ParentClass {


    public void clickCheckOutOnHeaderMenuBar(){

        clickTo(Locater.checkoutButtonOnHeaderMenuBar);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locater.billingDetailsTextOnCheckOutPage));
    }

    public void clickCheckOutOnMiniCart(){

        hoverTo(getElement(Locater.miniCartIcoOnHeaderMenu));
        clickTo(By.xpath("(//a[@class='button checkout wc-forward'])[1]"));


    }

    public void clickProceedtoCheckOutButtonOnCart(){

        clickTo(getElement(Locater.proceedtoCheckoutButtonOnCart));
        Assert.assertTrue(getElement(Locater.billingDetailsTextOnCheckOutPage).isDisplayed());


    }

    public void fillBillingDetailsForm(){
        clickTo(By.cssSelector("ul.ast-checkout-control-nav"));
        sleep(5000);


        //scrollIntoViewFalse(getElement(By.cssSelector("input#username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#billing_first_name")));

        sendkeysTo((By.cssSelector("input#billing_first_name")),"username");
        sendkeysTo((By.cssSelector("input#billing_last_name")),"lastname");
        sendkeysTo((By.cssSelector("input#billing_address_1")),"adress1 cadde2");
        sendkeysTo((By.cssSelector("input#billing_postcode")),"3216");
        sendkeysTo((By.cssSelector("input#billing_city")),"istanbul");
        sendkeysTo((By.cssSelector("input#billing_phone")),"+905554443322");
        sendkeysTo((By.cssSelector("input#billing_email")),"tester005@gmail.com");

        scrollIntoViewFalse(getElement(By.cssSelector("li.flex-nav-next a")));
        clickTo(getElement(By.cssSelector("li.flex-nav-next a")));


    }

    public void selectPaymentMethodandClickSendOrderButton(){
        sleep(1000);
        //scrollIntoView(getElement(By.cssSelector("input#payment_method_woocommerce_payments")));
        clickTo(By.cssSelector("input#payment_method_woocommerce_payments"));

        sleep(4000);

        driver.switchTo().frame(8);

        sleep(2000);

        scrollIntoViewFalse(getElement(By.cssSelector("input#Field-numberInput")));
        sendkeysTo(By.cssSelector("input#Field-numberInput"),"5555 5555 5555 4444");
        sendkeysTo(By.cssSelector("input#Field-expiryInput"),"1027");
        sendkeysTo(By.cssSelector("input#Field-cvcInput"),"901");

        driver.switchTo().defaultContent();

        clickTo(By.cssSelector("input#terms"));

        clickTo(By.cssSelector("button#place_order"));


    }
    String orderNumber ;
    public void clickOrderReviewButtonOnCheckOutPage(){
        clickTo(getElement(Locater.orderReviewButtonOnCheckOutPage));

        Assert.assertEquals(getText(Locater.orderOverviewAndPaymentMethodTextonCheckOutPage2),"Kasse");



    }

    public void  selectPaymentMethodAndSendOrderButton(){

        clickTo(getElement(Locater.creditCardPaymentMethodRadioButton)); // by Credit card
        sleep(2000);
        JSClickTo(getElement(Locater.firstSavedCreditCartOption)); // first saved credit card
        sleep(2000);
        clickTo(getElement(Locater.checkboxAboveSendOrderButton)); // checkbox
        clickTo(getElement(Locater.sendOrderButtonOnCheckOutPage2)); // send order button
        orderNumber=getText(Locater.orderDetailsOrderNumberText);
        sleep(2000);


    }

    public void validateOrderDetailsTextAfterCheckout(){

        sleep(2000);
        Assert.assertEquals(getElement(Locater.orderAllDetailsTextAfterCheckOut).getText(),"Bestelldetails");

    }

    public void  validateOrderNumberOnMyAccountOrdersList(){
         clickTo(Locater.myAccountLinkOnHeaderMenu);

         clickTo(Locater.myAccountOrdersList);
         System.out.printf(getText(Locater.myAccountOrdersFirstOrderNumberText));
         System.out.printf(orderNumber);

         Assert.assertTrue(getText(Locater.myAccountOrdersFirstOrderNumberText).contains(orderNumber));

         orderNumber=null;



    }







}
