package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.AllProductsPage;

public class CartPageStepDefs {

    CartPage cartP = new CartPage();
    AllProductsPage categoryP = new AllProductsPage();
    @When("user adds {int} random products to cart from main page")
    public void userAddsProductsToCartFromMainPage(int productCount) {

        cartP.addProductToCartOnMainPage(productCount);

    }

    @Then("product names should be in main cart page")
    public void productNamesShouldBeInMainCartPage() {

        cartP.validateProductNamesOnMainCartPage();
    }

    @And("user add {int} product to cart on All catagories")
    public void userAddProductToCartOnAllCatagories(int productCount) {
        cartP.addProductToCartOnMainPage(productCount);
    }





    @And("user clicks and add product to cart from display page clicks main cart from display page")
    public void userClicksAndAddProductToCartFromDisplayPageClicksMainCartFromDisplayPage() {

        cartP.clickProductOnAllCatagoriesAndAddToCartGoesToMainCartFromDisplayPage();
    }



    @And("user update all product quantities in main cart")
    public void userUpdateAllProductQuantitiesInMainCart() {
        cartP.updateAllProductQuantitiesOnMainCart();
    }


    @Then("product quantities should be new values")
    public void productQuaitiesShouldBeNewValues() {
        cartP.validateNewQuantityAfterUpdatingCart();
    }


    @And("user clicks all remove icons on main cart")
    public void userClicksAllRemoveIconsOnMainCart() {
        cartP.removeAllProductsFromMainCart();
    }


    @Then("main cart should be empty")
    public void mainCartShouldBeEmpty() {
        cartP.validateEmptyCartAfterRemovingAllProduct();
    }

    @And("user clicks all products and adds random {int} product to cart on All catagories")
    public void userClicksAllProductsAndAddsRandomProductToCartOnAllCatagories(int productCount) {
        categoryP.clickToAllProductsAndShowAll();
        cartP.clickProductOnAllProductsAndAddToCart(productCount);
    }

    @When("user clicks random {int} product from all products page and add product to cart from product display page")
    public void userClicksRandomProductFromAllProductsPageAndAddProductToCart(int count) {
        categoryP.clickToAllProductsAndShowAll();
        cartP.clickProductOnAllProductsAndAddToCart(count);
    }

    @And("user clicks main cart on {string} menu")
    public void userClicksMainCartOnMenu(String menu) {
        cartP.clickMainCartonMenu(menu);
    }
}
