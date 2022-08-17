package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.baseTest;

public class personalLoansCalcultorPageObjects extends baseTest
{

    public personalLoansCalcultorPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public By getHowMuchNeededList()
    {
        return By.xpath("//*[@id='loanAmount']/div/div/div/om-form-dropdown-field/div/div[1]/span[2]");
    }

    public By getHowLongList()
    {
        return By.xpath("//*[@id='repaymentDuration']/div/div/div/om-form-dropdown-field/div/div[1]/span[2]");
    }

    public By getAmountSelect()
    {
        return By.xpath("(//li[@id='R50000'])[1]");
    }

    public By getDurationSelect()
    {
        return By.xpath("(//li[@id='60 Months'])[1]");
    }

    public By getNextButton()
    {
        return By.xpath("(//button[@class='theme-default secondary-large'])[1]");
    }

    public By getCalculateButton()
    {
        return By.xpath("//button[@class='theme-default primary-large']");
    }

    public By getYourMonthlyAmount()
    {
        return By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > om-wc-config:nth-child(1) > div:nth-child(1) > om-page:nth-child(1) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > om-application-container:nth-child(2) > div:nth-child(1) > om-1-col-layout:nth-child(1) > div:nth-child(1) > om-section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > om-personal-loans-calculator:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > om-calculator-result:nth-child(1) > div:nth-child(4) > h5:nth-child(2) > strong:nth-child(1)");
    }

}
