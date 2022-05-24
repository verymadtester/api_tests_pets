package basic;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class TestFrame {

    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public void startReport(){
        extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);

        extent
                .addSystemInfo("Host Name", "Get Pets Tests")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Sergey Shatilov");

        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }

        extent.endTest(logger);
    }
    @AfterTest
    public void endReport(){
        extent.flush();
        extent.close();
    }
}
