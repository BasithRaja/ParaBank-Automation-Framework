package utilities;
	
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

	public class BaseClass {
		
		public static WebDriver driver;
		
		@BeforeMethod(alwaysRun=true)
		
		public void launchBrowser() throws IOException
		{
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			opt.addArguments("--disable-password-generation");
			opt.addArguments("--incognito");
			
			String browserName = FetchDataFromProperty.getDataFromProperty().getProperty("browser");
			String URL = FetchDataFromProperty.getDataFromProperty().getProperty("url");
			
			
			if (browserName.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver(opt);
				driver.get(URL);
				driver.manage().window().maximize();
			}
			
			if (browserName.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
			}
			
			if (browserName.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
			}
		}
		
		
		public static void scrollDown()
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,400)","");
		}
		
		public static void acceptAlert()
		{
			driver.switchTo().alert().accept();
		}

		@AfterMethod(alwaysRun=true)
		
		public void closeBrowser()
		{
			driver.quit();
		}
		
	 }
		




