package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.MainPage;

public class MainPageStepDefs {
    MainPage mainP = new MainPage();
    LoginPage loginP = new LoginPage();

    @Given("user on main page and accept cookie")
    public void userOnMainPage() {
        mainP.gotoWebSite();
        loginP.acceptCookiesAlert();

    }

    @Then("all product images should be visible and working")
    public void allImagesShouldBeVisibleAndWorking() {

        mainP.validateAllImagesOnMainPage();

    }


}
