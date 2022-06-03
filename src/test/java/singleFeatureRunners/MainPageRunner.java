package singleFeatureRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import utils.Browser;
import utils.Driver;


@CucumberOptions(
        features = {"src/test/java/features/_01_mainPage.feature"},
        glue = {"hooks","stepdefs"}
)
public class MainPageRunner extends AbstractTestNGCucumberTests {


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
