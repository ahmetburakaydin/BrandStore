package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllProductsPage;
import pages.WishListPage;

public class WishListStepDefs {
    AllProductsPage categoryP = new AllProductsPage();
    WishListPage wishListP = new WishListPage();



    @And("user clicks randomly a product's heart icon on main page")
    public void userClickProductSHeartIconRandomly() {

        wishListP.clickHeartIconOnProductImageOnMainPage();
        wishListP.gotoWishListFromHeaderMenu();

    }

    @Then("clicked product should be in wish list")
    public void clickedProductsShouldBeInWishList() {

        wishListP.validateProductNameOnWishList();

    }

    @And("user clicks on a product from All catagories")
    public void userClicksOnAProductFromAllCatagories() {

        wishListP.clickRandomProductOnAllProductsPage();

    }

    @And("user clicks add wish list link on product display page")
    public void userClicksAddWishListLinkOnProductDisplayPage() {

        wishListP.addWishListOnProductDisplayPage();

    }



    @And("user click product's heart icon two times")
    public void userClickProductSHeartIconTwoTimes() {

        wishListP.clickHeartIconTwoTimesOnProductImageOnMainPage();
    }

    @And("user click similar product's heart icons randomly")
    public void userClickSimilarProductSHeartIconsRandomly() {

        wishListP.clickSimilarProductsHeartIconRandomly();


    }

    @And("user on wish list page")
    public void userOnWishListPage() {

        wishListP.gotoWishListFromHeaderMenu();

    }


    @And("user remove all products from wish list")
    public void userRemoveAllProductsFromWishList() {

        wishListP.removeAllProductFromWishList();

    }

    @Then("no product should be in wish list")
    public void noProductShouldBeInWishList() {

        wishListP.validateNoProductsInWishList();

    }

    @And("user goes to wish list from same product's {string} icon")
    public void userGoesToWishListFromSelectedLink(String menu) {

        wishListP.gotoWishListFromSelectedLink(menu);

    }

    @And("user clicks all products and then clicks randomly a product's heart icon")
    public void userClicksAllProductsAndRandomlyClicksProductsHeartIcon() {

        categoryP.clickToAllProductsAndShowAll();
        wishListP.clickRandomProductsHeartIconOnAllProductsPage();

    }

    @When("user clicks random product from all products page")
    public void userClicksRandomProductFromAllProductsPage() {

        categoryP.clickToAllProductsAndShowAll();
        wishListP.clickRandomProductOnAllProductsPage();

    }

    @And("user clicks add wish list link and goes to wish list from {string}")
    public void userClicksAddWishListLinkAndGoesToWishListFrom(String menu) {
        wishListP.addWishListOnProductDisplayPage();
        wishListP.gotoWishListFromSelectedLink(menu);

    }

    @And("user goes to wish list from {string} menu")
    public void userGoesToWishListFromMenu(String menu) {
        wishListP.gotoWishListFromSelectedLink(menu);
    }


}
