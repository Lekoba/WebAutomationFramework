package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class reportsHelper {

    public static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    protected ExtentTest test;

    reportsHelper(){

    }
    // @BeforeSuite
    public static ExtentReports reportSetup()
    {
        try
        {
            if(extent == null)
            {
                String datetime =   LocalDateTime.now().toString().replace("/","").replace(":","").replace(" ","").replace("-","").replace(".","");
                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Report/WebReport"+ datetime+".html");
                htmlReporter.config().setDocumentTitle("Execution Report");
                htmlReporter.config().setReportName("End To End Report");
                htmlReporter.config().setTheme(Theme.DARK);
                extent = new ExtentReports();
                extent.attachReporter(htmlReporter);
                extent.setSystemInfo("Hostname", "Localhost");
                extent.setSystemInfo("OS", "Windows");
                extent.setSystemInfo("OS", "MAC");
                extent.setSystemInfo("Browser", "Chrome");
                extent.setSystemInfo("Environment", "Dev_Env");
                extent.setSystemInfo("Tester Name", "Tester Name");

            }
        }
        catch (Exception ex)
        {

        }


        return extent;
    }

    public static String get_Current_System_Time() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date date = new Date();

        String date1 = dateFormat.format(date);

        System.out.println(date1);

        return date1;
    }

}
