package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AllProductsPage;
import pages.ComparisonPage;

public class ComparisonPageStepDefs {


    ComparisonPage compareP = new ComparisonPage();
    AllProductsPage categoryP = new AllProductsPage();
    @And("user clicks on a product from All catagories for comparison")
    public void userClicksOnAProductFromAllCatagoriesForComparison() {
        compareP.clickRandomProductOnAllCatagoriesForComparison();
    }

    @And("user click add comparison list link on display page")
    public void userClickAddComparisonListLinkOnDisplayPage() {
        compareP.addProductCompareList();

    }


    @And("user clicks on same product from All catagories for comparison")
    public void userClicksOnSameProductFromAllCatagories() {
        compareP.clickSameProductonAllCatagoriesForComparison();

    }



    @Then("{int} product should be in comparison list")
    public void oneProductShouldBeInComparisonList(int num) {
        compareP.validateProductNameOnComparisonList(num);
    }

    @And("user goes to comparison list page from header menu")
    public void userGoesToComparisonListPage() {
        compareP.clickComparisonListLinkOnHeaderMenu();
    }

    @And("user goes to comparison list page from footer menu")
    public void userGoesToComparisonListPageFromFooterMenu() {
        compareP.clickComparisonListLinkOnFooterMenu();
    }

    @And("user remove all products from comparison list")
    public void userRemoveAllProductsFromComparisonList() {
        compareP.removeAllProductsFromComparisonList();
    }

    @Then("no product result text should be visible")
    public void noProductResultTextShouldBeVisible() {
        compareP. validateNoProductResultTextInComparisonList();
    }

    @And("user clicks random {int} products from all products page and clicks add comparison list link")
    public void userClicksRandomProductFromAllProductsPageAndClicksAddComparisonListLink(int repetitionCount) {
        for (int i = 0; i < repetitionCount ; i++) {
            categoryP.clickToAllProductsAndShowAll();
            compareP.clickRandomProductOnAllCatagoriesForComparison();
            compareP.addProductCompareList();
        }


    }

    @And("user clicks same product from all products page and clicks add comparison list link")
    public void userClicksSameProductFromAllProductsPageAndClicksAddComparisonListLink() {
        categoryP.clickToAllProductsAndShowAll();
        compareP.clickSameProductonAllCatagoriesForComparison();
        compareP.addProductCompareList();


    }
}
