package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports createExtentReport() {

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Project", "ParaBank Automation Framework");
        extent.setSystemInfo("Tester", "Basith Raja");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}