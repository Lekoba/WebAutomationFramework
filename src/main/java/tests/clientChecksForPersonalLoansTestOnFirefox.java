package tests;

import applicationFunctions.applicationFunctions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.applicationSpecific;
import utilities.baseTest;


public class clientChecksForPersonalLoansTestOnFirefox extends baseTest
{
    applicationFunctions applicationFunctions = new  applicationFunctions();

    @BeforeTest
    public void setUpTest()
    {
        //Initializing the Browser
        initializeMobileBrowser(this.getClass().getName(), "firefox");
    }

    @Test
    public void clientChecksForPersonalLoansTestOnFirefox()
    {
        try
        {
            //Getting the Page Title
            applicationFunctions.getPageTitleProcess(driver, extentTest);
            //Navigate to Personal
            applicationFunctions.navigateToPersonalLoanPage(driver, extentTest);
            //Click the button Calculator
            applicationFunctions.clickCalculateOnPersonalPersonalLoan(driver, extentTest);
            //Performing the Calculations
            applicationFunctions.performingCalculateOnPersonalPersonalLoan(driver, extentTest);
        }
        catch (Exception ex)
        {
            System.out.print("message :" +ex.getMessage());
        }
    }
}
