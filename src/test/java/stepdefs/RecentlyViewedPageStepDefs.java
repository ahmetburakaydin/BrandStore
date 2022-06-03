package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AllProductsPage;
import pages.RecentlyViewedPage;

public class RecentlyViewedPageStepDefs {
    AllProductsPage categoryP = new AllProductsPage();
    RecentlyViewedPage recentlyP = new RecentlyViewedPage();

    @Then("products should  be visible recently viewed section")
    public void productsShouldBeVisibleRecentlyViewedSection() {
        recentlyP.validateProductNamesOnRecentlyViewedSection();
    }

    @And("user clicks all products and displays two products one after another")
    public void userClicksAllProductsAndDisplaysTwoProductsOneAfterAnother() {
        categoryP.clickToAllProductsAndShowAll();
        recentlyP.displayTwoProducts();
    }
}
