package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter =new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Varun Awadhiya");
        return extent;
    }
}
