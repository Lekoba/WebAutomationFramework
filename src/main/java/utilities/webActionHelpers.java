package utilities;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class webActionHelpers extends applicationSpecific
{
    public String getPageTilte(WebDriver driver)
    {
        String title = null;
        try
        {
            title = driver.getTitle();
        }
        catch(Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
        return title;
    }
    public void enterText(WebDriver driver, By sElement, String text)
    {
        try
        {
            WebElement element = driver.findElement(sElement);
            element.clear();
            element.sendKeys(text);
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
    }

    public void scrollUp(WebDriver driver)
    {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).build().perform();
    }

    public void scrollDown(WebDriver driver)
    {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void clickElement(WebDriver driver, By sElement)
    {

        try
        {
            WebElement element = driver.findElement(sElement);
            element.click();
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
    }

    public void clickElementUsingJavaScript(WebDriver driver,By sElement)
    {
        try
        {    WebElement element = driver.findElement(sElement);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
    }

    public void waitForElement(WebDriver driver, WebElement sElement)
    {
    }

    public boolean checkIsDisplayed(WebDriver driver,By sElement)
    {
        boolean isDisplayed = false;
        try
        {
            WebElement element = driver.findElement(sElement);
            isDisplayed = element.isDisplayed();
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
        return isDisplayed;
    }

    public String getText(WebDriver driver,By sElement)
    {
        String text = null;
        try
        {
            WebElement element = driver.findElement(sElement);
            text = element.getText();
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
        return text;
    }

    public boolean verifyPageDisplayed(String expectText, String text)
    {
        boolean isDisplayed = false;
        try
        {
            if (expectText.equalsIgnoreCase(text))
            {
                System.out.println("The expected cart is same as actual cart value --- " + expectText);
                isDisplayed = true;
            }
            else
            {
                System.out.println("The expected cart is not the same as actual cart value --- " + expectText);
                isDisplayed = false;
            }
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
        return isDisplayed;
    }

    public void takeSnapShot(WebDriver driver, String screeShotName)
    {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screenshot, new File(".//ScreenShorts/" + screeShotName + ".png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public static String capture(WebDriver driver, String screeShotName)
    {
        String filePath = null;
        try
        {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File Dest = new File(".//ScreenShorts/" + screeShotName + ".png");
            filePath = Dest.getAbsolutePath();
            FileUtils.copyFile(scrFile, Dest);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return filePath;
    }

    public static String captureScreenShot(WebDriver driver)
    {
        String encodedBase64 = null;
        try
        {
            encodedBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return encodedBase64;
    }

    public void extentLogPass(String message, WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            String fileName = captureScreenShot(driver);
            extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void extentLogFail(String message, WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            String fileName = captureScreenShot(driver);
            extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void extentLogSkip(String message, WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            String fileName = captureScreenShot(driver);
            extentTest.skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void extentLogInfo(String message, WebDriver driver, ExtentTest extentTest)
    {
        try
        {
            String fileName = captureScreenShot(driver);
            extentTest.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public boolean checkElementIsEnable(WebDriver driver, WebElement sElement)
    {
        boolean isEnabled = false;
        try
        {
            isEnabled = sElement.isEnabled();
        }
        catch (Exception ex)
        {
            System.out.println("Cause of error: " + ex.getCause());
        }
        return isEnabled;
    }

}
