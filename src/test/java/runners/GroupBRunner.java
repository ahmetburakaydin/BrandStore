package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestListener;

@CucumberOptions(
        features =  {"src/test/java/features"},
        glue = {"stepdefs","hooks"},

        //plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"},
         plugin = {  "pretty","html:test-output/cucumber-report.html",
                    "json:target/cucumber-json.json", "summary" ,
                    "junit:test-output/XMLreport.xml"},
       tags = "@GroupB"
)
public class GroupBRunner extends AbstractTestNGCucumberTests implements ITestListener {


}
