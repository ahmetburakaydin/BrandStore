package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features =  {"src/test/java/features"},
        glue = {"stepdefs","hooks"},

        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
       tags = "@GroupA or @GroupB"
        //tags = "@GroupA"
        //tags = "@GroupB"
)
public class Runner extends AbstractTestNGCucumberTests  {



}
