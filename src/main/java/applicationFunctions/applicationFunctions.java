package applicationFunctions;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.navigateToPersonalLoanPageObjects;
import pageObjects.personalLoansCalcultorPageObjects;
import utilities.applicationSpecific;
import utilities.baseTest;
import utilities.webActionHelpers;

import java.util.ArrayList;

import static utilities.applicationSpecific.getPersonalLoanURL;

public class applicationFunctions extends baseTest
{
    webActionHelpers webActionHelpers = new webActionHelpers();
    applicationSpecific  applicationSpecific = new applicationSpecific();
    navigateToPersonalLoanPageObjects navigateToPersonalLoan = new  navigateToPersonalLoanPageObjects(driver);
    personalLoansCalcultorPageObjects personalLoansCalcultor =new  personalLoansCalcultorPageObjects(driver);

    public void getPageTitleProcess(WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            if(webActionHelpers.getPageTilte(driver).equals("Bank and Borrow Solutions | Old Mutual"))
            {
                System.out.println("Page title displayed successfully");
                webActionHelpers.extentLogPass("Page title displayed successfully", driver, extentTest);
            }
            else
            {
                System.out.println("Page title displayed successfully");
                webActionHelpers.extentLogFail("Page title displayed successfully", driver, extentTest);
                Assert.fail();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
            Assert.fail();
        }

    }

    public void navigateToPersonalLoanPage(WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            applicationSpecific.navigateURL(getPersonalLoanURL());
           if(webActionHelpers.checkIsDisplayed(driver, navigateToPersonalLoan.getLabelOurSolution()))
           {
               webActionHelpers.clickElement(driver,navigateToPersonalLoan.getLabelOurSolution());
               Thread.sleep(1000);
               webActionHelpers.clickElementUsingJavaScript(driver,navigateToPersonalLoan.getLabelPersonalLoan());
               webActionHelpers.extentLogPass("Personal Loan Link displayed", driver, extentTest);
           }
           else
           {
               webActionHelpers.extentLogFail("Personal Loan Link Not displayed", driver, extentTest);
               Assert.fail();
           }
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
            Assert.fail();
        }
    }

    public void clickCalculateOnPersonalPersonalLoan(WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            applicationSpecific.navigateURL(applicationSpecific.getPersonalLoanURL());
            if(webActionHelpers.checkIsDisplayed(driver, navigateToPersonalLoan.getButtonCalculate()))
            {
                webActionHelpers.clickElement(driver,navigateToPersonalLoan.getButtonCalculate());

                webActionHelpers.extentLogPass("Calculate button successfully clicked", driver, extentTest);

                Thread.sleep(1000);

                ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs2.get(1));
                //driver.switchTo().window(tabs2.get(0));
            }
            else
            {
                webActionHelpers.extentLogFail("Calculate button successfully Not clicked", driver, extentTest);
                Assert.fail();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
            Assert.fail();
        }
    }

    public void performingCalculateOnPersonalPersonalLoan(WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            Thread.sleep(5000);
            if(webActionHelpers.getPageTilte(driver).contains("Personal Loan Calculator | Estimate Instalments | Old Mutual"))
            {
                System.out.println("Page title displayed successfully");
                webActionHelpers.extentLogPass("Page title displayed successfully", driver, extentTest);
                Thread.sleep(2000);
                if(webActionHelpers.checkIsDisplayed(driver, personalLoansCalcultor.getNextButton()))
                {
                    webActionHelpers.scrollDown(driver);
                    webActionHelpers.scrollDown(driver);
                    webActionHelpers.clickElement(driver,personalLoansCalcultor.getHowMuchNeededList());

                    Thread.sleep(5000);
                    webActionHelpers.clickElement(driver,personalLoansCalcultor.getAmountSelect());

                    webActionHelpers.extentLogPass("Amount successfully selected", driver, extentTest);
                    Thread.sleep(2000);
                    webActionHelpers.clickElement(driver,personalLoansCalcultor.getNextButton());

                    Thread.sleep(2000);

                    webActionHelpers.clickElement(driver,personalLoansCalcultor.getHowLongList());

                    Thread.sleep(5000);

                    webActionHelpers.clickElement(driver,personalLoansCalcultor.getDurationSelect());

                    webActionHelpers.extentLogPass("Amount successfully selected", driver, extentTest);

                    Thread.sleep(2000);

                    webActionHelpers.clickElement(driver,personalLoansCalcultor.getCalculateButton());

                    Thread.sleep(1000);
                    webActionHelpers.scrollDown(driver);

                    String text = webActionHelpers.getText(driver,personalLoansCalcultor.getYourMonthlyAmount());
                    if(text.contains("R1 656.43 - R1 810.05"))
                    {
                        webActionHelpers.extentLogPass("Amount is validated", driver, extentTest);
                    }
                    else
                    {
                        webActionHelpers.extentLogFail("Amount is NOT validated", driver, extentTest);
                        Assert.fail();
                    }

                }
                else
                {
                    webActionHelpers.extentLogFail("Amount successfully selected", driver, extentTest);
                    Assert.fail();
                }
            }

        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
            Assert.fail();
        }
    }


}
