package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.MainPage;
import pages.PurchasePage;

public class PurchasePageStepDefs {

    PurchasePage purchaseP=new PurchasePage();
    LoginPage loginP = new LoginPage();
    MainPage mainP = new MainPage();



    @Then("all order details should be visible on checkout pagee")
    public void allOrderDetailsShouldBeVisibleOnCheckoutPagee() {
        purchaseP.validateOrderDetailsTextAfterCheckout();
    }

    @And("user clicks checkout on header menu")
    public void userClicksCheckoutOnHeaderMenu() {
        purchaseP.clickCheckOutOnHeaderMenuBar();
    }

    @And("user fills billing details forms and clicks the order overview button")
    public void userFillsBillingDetailsFormsAndClicksTheOrderOverviewButton() {
        purchaseP.fillBillingDetailsForm();
        purchaseP.selectPaymentMethodandClickSendOrderButton();
    }

    @And("user clicks checkout on mini cart")
    public void userClicksCheckoutOnMiniCart() {
        purchaseP.clickCheckOutOnMiniCart();
    }

    @Then("order number should be visible on my account orders list")
    public void orderNumberShouldBeVisibleOnMyAccountOrdersList() {
        purchaseP.validateOrderNumberOnMyAccountOrdersList();
    }


    @And("user clicks proceed to checkout and order overview button and select payment method")
    public void userClicksProceedToCheckoutAndOrderOverviewButtonAndSelectPaymentMethod() {
        purchaseP.clickProceedtoCheckOutButtonOnCart();
        purchaseP.clickOrderReviewButtonOnCheckOutPage();
        purchaseP.selectPaymentMethodAndSendOrderButton();

    }

    @And("user clicks checkout on mini cart and fills billing details and clicks order overview button")
    public void userClicksCheckoutOnMiniCartAndFillsBillingDetailsAndClicksOrderOverviewButton() {
        purchaseP.clickCheckOutOnMiniCart();
        purchaseP.fillBillingDetailsForm();
        purchaseP.selectPaymentMethodandClickSendOrderButton();

    }
}
