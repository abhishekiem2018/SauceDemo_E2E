package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import utils.CommonUtils;
import utils.DriverFactory;
import utils.ExtentManager;

public class TestListener implements ITestListener {

    ExtentReports extent =ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("========== Executing Test Case: " + testName + " ==========");
        test = extent.createTest(testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        // 🔥 Get driver from BaseTest
        WebDriver driver = DriverFactory.getDriver();;
        System.out.println("TC got failed ");
        // 📸 Capture screenshot
        String screenshotPath =
                CommonUtils.captureScreenshot(driver,result.getMethod().getMethodName());
                System.out.println(screenshotPath);
        try {
            // Attach screenshot to report
//            test.addScreenCaptureFromPath(screenshotPath);
            test.fail("Screenshot below").addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }
}