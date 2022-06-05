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

        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
       tags = "@GroupA"
)
public class GroupARunner extends AbstractTestNGCucumberTests {
    @Parameters({"browserA"})
    @BeforeMethod
    public void beforeMethod(Browser browser){

        Driver.getDriver(browser);

    }


    @AfterMethod
    public void afterMethod(){

        Driver.quitDriver();

    }

}
