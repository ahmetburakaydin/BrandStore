package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllProductsPage;

public class CatagoryPageStepDefs {
    AllProductsPage catagoryP = new AllProductsPage();

    @When("user clicks all products")
    public void userClicksAllProdukteAndShowAllLink() {

        catagoryP.clickToAllProductsAndShowAll();

    }

    @Then("all products should have a image and a price")
    public void allProductShouldHaveAImageAndAPrice() {

        catagoryP.validateAllImagesandPrices();

    }

    @And("user clicks and selects from Katagorien dropdown menu randomly")
    public void userClicksAndSelectsFromKatagorienDropdownMenuRandomly() {

        catagoryP.selectFromDropdownMenu();

    }

    @Then("the result product's names should contain their dropdown menu names")
    public void theResultProductsNamesShouldContainTheirDropdownMenuNames() {

        catagoryP.validateDropDownMenuNameOnResult();

    }

    @And("user selects one of sorting criterias")
    public void userClicksOneOfSortingCriterias() {

        catagoryP.selectFromSortingCriterias();

    }

    @And("the result should come according to the criteria")
    public void theResultShouldComeAccordingToTheCriteria() {

        catagoryP.validateSelectingCriteriaResult();

    }

    @When("user clicks all products and selects random catagory from dropdown menu")
    public void userClicksAllProductsAndSelectRandomCatagoryFromDropdownMenu() {
        catagoryP.clickToAllProductsAndShowAll();
        catagoryP.selectFromDropdownMenu();
    }

    @And("user clicks all products and selects sorting criteria from dropdown menu")
    public void userClicksAllProductsAndSelectsSortingCriteriaFromDropdownMenu() {
        catagoryP.clickToAllProductsAndShowAll();
        catagoryP.selectFromSortingCriterias();
    }
}
