package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepDefs {
    LoginPage loginP = new LoginPage();

    @When("user accepts cookie notice")
    public void userAcceptsCookieNotice() {
        loginP.acceptCookiesAlert();
    }
    @When("user logins with valid {string} and {string}")
    public void userLoginsWithValidaAnd(String username, String password) {
        loginP.loginwithValidEmailandPassword(username,password);
    }

    @And("user logins as avalid infos")
    public void userLoginsWithValidInfos (String username,String password){
        loginP.loginwithValidEmailandPassword(username,password);
    }
    @Then("My account should be visible on main page")
    public void meineKuntoShouldBeVisibleOnMainPage() {
        loginP.validateLoggingInSite();
    }


}
