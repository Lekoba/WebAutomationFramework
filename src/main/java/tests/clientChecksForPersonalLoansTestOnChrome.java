package tests;

import applicationFunctions.applicationFunctions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.applicationSpecific;
import utilities.baseTest;
import utilities.constantsHelper;


public class clientChecksForPersonalLoansTestOnChrome extends baseTest
{
    applicationFunctions applicationFunctions = new  applicationFunctions();
    applicationSpecific applicationSpec = new applicationSpecific();

    @BeforeTest
    public void setUpTest()
    {
        //Initializing the Browser
        initializeMobileBrowser(this.getClass().getName(), "Chrome");
    }

    @Test
    public void clientChecksForPersonalLoansTestOnChrome()
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
