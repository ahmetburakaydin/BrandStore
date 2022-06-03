package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AllProductsPage;
import pages.SearchPage;

public class SearchPageStepDefs {

    SearchPage searchP = new SearchPage();
    AllProductsPage categoryP = new AllProductsPage();
    @And("user search {string}  header menu search field")
    public void userSearchHeaderMenuSearchField(String text) {
        searchP.searchOnHeaderSearchField(text);
    }


    @Then("result product's name should contain {string}")
    public void resultProductSNameShouldContain(String text) {
        searchP.validateKeywordOnSearchResultProducts(text);
    }
    @And("user clicks all products and searches {string} on header menu search field")
    public void userClicksAllProductsAndSearchesOnHeaderMenuSearchField(String text) {
        categoryP.clickToAllProductsAndShowAll();
        searchP.searchOnHeaderSearchField(text);
    }

    @And("user clicks all products and searches {string} left bottom search field on all catagories page")
    public void userClicksAllProductsAndSearchesLeftBottomSearchFieldOnAllCatagoriesPage(String text) {
        categoryP.clickToAllProductsAndShowAll();
        searchP.searchOnLeftBottomSearchField(text);

    }
}