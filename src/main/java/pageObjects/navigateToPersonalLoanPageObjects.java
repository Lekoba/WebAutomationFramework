package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.baseTest;

public class navigateToPersonalLoanPageObjects extends baseTest {

    public navigateToPersonalLoanPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public By getLabelOurSolution()
    {
        return By.xpath("(//a[contains(text(),'Our Solutions')])[1]");
    }

    public By getLabelPersonalLoan()
    {
        return By.xpath("//*[@id='gatsby-focus-wrapper']/om-wc-config/div/om-page/div/div/header/om-segment-landing-header/div/om-main-navigation/div[1]/nav/div[1]/div[2]/om-main-navigation-menu/ul/li[1]/ul/li[3]/ul/li[1]/ul/li[2]/a/");
    }


    public By getButtonCalculate()
    {
        return By.xpath("//*[@id='gatsby-focus-wrapper']/om-wc-config/div/om-page/div/div/header/om-header-with-breadcrumbs/div/om-hero-banner/div/div[3]/div[2]/om-hero-banner-content/span/om-button[2]/a");
    }


}
