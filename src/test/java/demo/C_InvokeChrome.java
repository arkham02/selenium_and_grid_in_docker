package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * This is a simple example that shows basic configuration for launching chrom
 * browser, navigating to a URL and using implicit wait
 * 
 * @author nitish
 *
 */
public class C_InvokeChrome {
	
	public static void main(String[] args) throws MalformedURLException {
		C_InvokeChrome invokeChrome=new C_InvokeChrome();
		invokeChrome.launch();
	}

	public WebDriver launch()  {

		//ChromeOptions capabilities= new ChromeOptions();
		FirefoxOptions capabilities = new FirefoxOptions();
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		System.out.println("maximize the browser window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(
				"Implict wait- wait for element to appear for x seconds, polling every 250ms. This wait would be applicable throughout the lifetime of the driver");

		System.out.println(
				"it also means that for every findElement it will wait for atleast 10 sec before throwing NoSuchElementException if the elementdoesnt exist on page");

		System.out.println("Navigate to a URL");
		driver.get("http://book.theautomatedtester.co.uk/chapter1");

		return driver;

	}

	public WebDriver launchOld() {
		System.out.println("Set chrome driver executable path");

		String projectPathTopLevel = System.getProperty("user.dir");
		String driverPath = projectPathTopLevel + "\\src\\test\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		System.out.println("Launching chrome browser");
		WebDriver driver = new ChromeDriver();

		System.out.println("maximize the browser window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(
				"Implict wait- wait for element to appear for x seconds, polling every 250ms. This wait would be applicable throughout the lifetime of the driver");

		System.out.println(
				"it also means that for every findElement it will wait for atleast 10 sec before throwing NoSuchElementException if the elementdoesnt exist on page");

		System.out.println("Navigate to a URL");
		driver.get("http://book.theautomatedtester.co.uk/chapter1");

		return driver;

	}
	
	public void quit(WebDriver driver){
		driver.quit();
	}
}
