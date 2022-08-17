package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class baseTest
{
   public static WebDriver driver;
   public applicationSpecific applicationSpecific = new applicationSpecific();
   public webActionHelpers webActionHelpers = new webActionHelpers();
   public reportsHelper reportsHelper = new reportsHelper();
    public static ExtentTest extentTest;
    public ExtentReports reports = reportsHelper.reportSetup();

    public void initializeMobileBrowser(String testName,String broswserType)
    {
        extentTest = reports.createTest(testName);
        try
        {
            applicationSpecific.setBrowserCaps();
            applicationSpecific.initializeWebBrowser(broswserType);
            applicationSpecific.navigateURL(applicationSpecific.getWebURL());
            //navigateURL(applicationSpecific.getWebURL());

        }
        catch (Exception ex)
        {
            System.out.print("The Message is: "+ ex.getMessage());
        }
    }

    @AfterSuite
     public void teardown() {
     reports.flush();
    }


}
