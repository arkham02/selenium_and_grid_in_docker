package demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This code snippet demonstrates how to handle new windows and creating custom
 * explicit wait conditions
 * 
 * @author nitish
 *
 */
public class G_NewWindows {
	C_InvokeChrome invokeChrome = new C_InvokeChrome();

	public static void main(String[] args) throws InterruptedException {
		G_NewWindows newWindows = new G_NewWindows();
		newWindows.handleNewWindow();
	}

	private void handleNewWindow() throws InterruptedException {

		WebDriver driver = invokeChrome.launch();
		System.out.println("Find all the elements matching the given xpath");
		List<WebElement> divs = driver.findElements(By.xpath("//div[contains(@class,'multiplewindow')]"));

		for (WebElement div : divs) {
			System.out.println("class atrribute value:-" + div.getAttribute("class"));
		}

		System.out.println("store the current window handle");
		final String currentWindowHandle = driver.getWindowHandle();

		System.out.println("Iterate over the list found above and click on the element which matches the text first");
		for (WebElement div : divs) {
			if (div.getText().toLowerCase().contains("click this link")) {
				div.click();
				break; // break out of the loop as match has been found
			}
		}

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// create a custom wait

		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {

				return driver.getWindowHandles().size() > 1;
			}
		});

		System.out.println("get all the windows handles");
		Set<String> windowHandles = driver.getWindowHandles();

		System.out.println("assert that there must be 2 windows");
		assertThat("pop up windows must be opened", windowHandles.size(), equalTo(2));

		boolean windowFound = false;
		for (String windowHandle : windowHandles) {

			System.out.println(
					"in order to perform operations on a new window, its necc to switch the driver to that window handle");

			driver.switchTo().window(windowHandle);

			try {
				// get the text inside the pop up
				WebElement para = driver.findElement(By.id("popuptext"));
				System.out.println(
						"right window has been found, else above line would have thrown NoSuchElementException");

				windowFound = true;
				driver.manage().window().maximize();

				System.out.println("text inside pop up:-" + para.getText());

				Thread.sleep(3000);

				// close this window on which selenium handle is currently
				// siwtched to. Dont use quit(), it would close all windows
				driver.close();
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element not found on the page. Not the right now");
			}
		}
		
		
		assertTrue("desired window found", windowFound);

		System.out.println("switch back to main window");
		driver.switchTo().window(currentWindowHandle);

		assertThat("verify we are on main window", driver.getTitle(), equalTo("Selenium: Beginners Guide"));
		driver.quit();

	}
}
