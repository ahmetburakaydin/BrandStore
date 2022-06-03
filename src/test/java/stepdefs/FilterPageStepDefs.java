package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllProductsPage;
import pages.FilterPage;

public class FilterPageStepDefs {

    FilterPage filterP = new FilterPage();
    AllProductsPage categoryP= new AllProductsPage();

    @And("user clicks products filter button")
    public void userClicksProdukteFilterButton() {

        filterP.clickProdukteFilterButton();

    }
    @Then("filter result products prices should be between min and max prices")
    public void filterResultProductsPricesShouldBeBetweenMinAndMaxPrices() {

        filterP.validateFilterProductResultswithPrices();

    }
    @Then("result product should contain color name")
    public void resultProductShouldContainColorName() {
        filterP.validateColorNameAfterFilterByColor();
    }

    @Then("result product should contain size name")
    public void resultProductShouldContainSizeName() {
        filterP.validateSizeTextAfterFilterBySize();
    }

    @Then("result product should contain material name")
    public void resultProductShouldContainMaterialName() {

        filterP.validateMaterialTextAfterFilterByMaterial();

    }@Then("result product should contain gender name")
    public void resultProductShouldContainGenderName() {
        filterP.validateGenderTextAfterFilterByMaterial();
    }

    @When("user clicks all products and clicks products filter button")
    public void userClicksAllProductsAndClicksProductsFilterButton() {
        categoryP.clickToAllProductsAndShowAll();
        filterP.clickProdukteFilterButton();
    }


    @And("user randomly selects {string} filter and clicks filter now button")
    public void userRandomlySelectsFilterAndClicksFilterNowButton(String filter) {
        filterP.selectRandomlyFilterKeyWordsFromDropdown(filter);
    }


}
