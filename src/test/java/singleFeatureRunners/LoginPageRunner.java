package singleFeatureRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import utils.Browser;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/_02_loginPage.feature"},
        glue = {"stepdefs"}
)
public class LoginPageRunner extends AbstractTestNGCucumberTests {

    @Parameters ({"browser"})
    @BeforeMethod
    public void beforeMethod(Browser browser){

        Driver.getDriver(browser);

    }


    @AfterMethod
    public void afterMethod(){

        Driver.quitDriver();

    }

}
