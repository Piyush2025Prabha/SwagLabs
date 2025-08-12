package Base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Util.WebDriverFactory;

public class BaseTest {
	public static WebDriver Driver;
	public static ExtentReports Reports;
	
  public static void LaunchBrowser(String bname,String appurl) throws MalformedURLException {
	  Driver = WebDriverFactory.getWebDriver(bname);
	  Driver.get(appurl);
  }
  public static void CloseBrowser() {
	 WebDriverFactory.quitDriver();
  }
  public static void CaptureScreenshot(String TestName) {
	  
	  String Filename = System.getProperty("user.dir") + "//Screenshots//"+ "TestName" + "_" +System.currentTimeMillis() + ".png";
	  File Source = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
	  File Destination = new File(Filename);
	  try {
		org.openqa.selenium.io.FileHandler.copy(Source, Destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  @BeforeSuite
  public static ExtentReports extentReport() {
	  
	  String RecordPath = System.getProperty("user.dir") + "//Report//ExtentReport.html";
	  ExtentSparkReporter HTMLReport = new ExtentSparkReporter(RecordPath);
	  HTMLReport.config().setReportName("SwagLabs HTML Report");
	  HTMLReport.config().setDocumentTitle("Selenium TestNG Report");
	  HTMLReport.config().setTheme(Theme.DARK);
	  
	  Reports = new ExtentReports();
	  Reports.attachReporter(HTMLReport);
	  Reports.setSystemInfo("Project Name", "Maven Swag Labs Project");
	  Reports.setSystemInfo("QA", "Piyush Prabha Panda");
	  Reports.setSystemInfo("Browser", "Google Chrome");
	  
	  return Reports;
  }
  @AfterSuite
  public void afterTest() {
	  if (Reports != null) {
          Reports.flush();
      }  
  }
}
