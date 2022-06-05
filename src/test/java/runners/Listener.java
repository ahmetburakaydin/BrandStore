package runners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static utils.Logger1.getLogger;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {


        getLogger().info("on Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getLogger().info(" on Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getLogger().error(" on Test Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getLogger().warn(" on Test Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        getLogger().info(" on Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        getLogger().info(" on Finish");
    }
}
