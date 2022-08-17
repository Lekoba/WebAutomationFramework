package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static utilities.baseTest.driver;

public class applicationSpecific
{
    public static String webURL;
    public static String personalLoanURL;
    public static String edge;
    public static String chrome;

    public static String getWebURL() {
        return webURL;
    }

    public static void setWebURL(String strWebURL) {
        webURL = strWebURL;
    }

    public static String getPersonalLoanURL() {
        return personalLoanURL;
    }

    public static void setPersonalLoanURL(String personal) {
        personalLoanURL = personal;
    }

    public static String getEdge() {
        return edge;
    }

    public static void setEdge(String edge) {
        applicationSpecific.edge = edge;
    }

    public static String getChrome() {
        return chrome;
    }

    public static void setChrome(String chrome) {
        applicationSpecific.chrome = chrome;
    }


    public void setBrowserCaps() throws FileNotFoundException
    {
        JSONParser parser = new JSONParser();
        FileReader fr;
        fr = new FileReader(new File(System.getProperty("user.dir")+ "/config/Environment.json"));

        try
        {
            Object object = parser.parse(fr);
            JSONObject jsonObject = (JSONObject) object;

            setWebURL((String) jsonObject.get("WEB_URL"));
            setPersonalLoanURL((String) jsonObject.get("PERSONAL_LOAN_URL"));
            setChrome((String) jsonObject.get("CHROME_BROWSER"));
            setEdge((String) jsonObject.get("EDGE_BROWSER"));

        }
        catch (Exception ex)
        {
            System.out.println("Error Initialising Android Browser Capabilities : " + ex.getMessage());
        }
    }

    public void initializeWebBrowser(String browserType)
    {
        try
        {
            switch (browserType.toUpperCase())
            {
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();

                    //navigateURL(getWebURL());

                case "EDGE":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();

                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
            }
        }
        catch (Exception ex)
        {
            System.out.print("message :" + ex.getMessage());
        }

    }

    public void navigateURL(String url)
    {
        try
        {
            driver.get(url);
            Thread.sleep(2000);
        }
        catch (Exception ex)
        {
            System.out.print("message :" + ex.getMessage());
        }
    }

}