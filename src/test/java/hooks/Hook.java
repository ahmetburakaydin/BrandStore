package hooks;


import io.cucumber.java.*;
import static utils.Logger1.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import utils.Browser;
import utils.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static utils.ExcelUtility.*;

public class Hook {

    WebDriver driver;

    @BeforeAll
    public static void beforeall() {

        List<String> headerList = new LinkedList<>(Arrays.asList("Test Name ", "Test Status", "Date and Time"));

        /*createData();
        writeHeader(headerList);
        writeDataList(new ArrayList<>(Arrays.asList("Test started", "Start Date and Time", getCurrentTime())));
        saveData();*/

        getLogger().info("Test Started");

    }

    @Before
    public void beforeScenario(Scenario scenario) {
        driver = Driver.getDriver();

        /*createData();
        writeDataList(new ArrayList<>(Arrays.asList(scenario.getName(), "Senaryo Başladı", getCurrentTime())));
        saveData();*/

        getLogger().info("SCENARIO : '"+scenario.getName()+"' - is started");


    }

    @After
    public void afterScenario(Scenario scenario) {

        //createData();
        if (scenario.isFailed()) {
            //writeDataList(new ArrayList<>(Arrays.asList(scenario.getName(), "Unsuccessful", getCurrentTime())));
            getLogger().error("SCENARIO : "+scenario.getName()+" - is FAILED");
        } else {
            //writeDataList(new ArrayList<>(Arrays.asList(scenario.getName(), "Successful", getCurrentTime())));
            getLogger().info("SCENARIO : "+scenario.getName()+" - is over");
        }
        //saveData();

        Driver.quitDriver();

    }

    @AfterAll
    public static void afterAll() {

       /* createData();
        writeDataList(new ArrayList<>(Arrays.asList("Test is Over", "End Date and Time", getCurrentTime())));
        saveData();*/

        getLogger().info("Test is Over");

    }

}
