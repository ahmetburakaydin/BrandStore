package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.Browser;
import utils.Driver;

@CucumberOptions(
        features =  {"src/test/java/features"},
        glue = {"stepdefs"},

        //plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"},
         plugin = {  "pretty","html:test-output/cucumber-report.html"},
       tags = "@GroupB"
)
public class GroupBRunner extends AbstractTestNGCucumberTests implements ITestListener {

    @Parameters({"browserB"})
    @BeforeMethod
    public void beforeMethod(Browser browser){

        Driver.getDriver(browser);

    }


    @AfterMethod
    public void afterMethod(){

        Driver.quitDriver();

    }
}
