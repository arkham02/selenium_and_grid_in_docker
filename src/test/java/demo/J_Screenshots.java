package demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class J_Screenshots {
	C_InvokeChrome invokeChrome = new C_InvokeChrome();

	public static void main(String[] args) throws  IOException {
		J_Screenshots screenshots = new J_Screenshots();
		screenshots.captureScreenshot();
	}

	private void captureScreenshot() throws  IOException {

		WebDriver driver = invokeChrome.launch();
		try {
			System.out.println("assert the title of the page");
			assertThat("Page title must match", driver.getTitle(), equalTo("Fail this test and capture screenshot"));
		} catch (AssertionError e) {
			System.out.println("type cast webdriver to TakesScreenshot Interface");
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

			System.out.println("Capture screenshot and assign it to a file");
			File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

			System.out.println("Create the destination where the screenshot needs to be copied");
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\"
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + ".jpg";
			System.out.println(filePath);

			System.out.println("Create destination file instance");
			File destFile = new File(filePath);

			System.out.println("copy file from source to destination");
			FileUtils.copyFile(srcFile, destFile);

			invokeChrome.quit(driver);

		}

	}
}
