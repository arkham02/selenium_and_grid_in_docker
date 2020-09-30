package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

/**
 * This code snippet demonstrates use of different locator strategies and explicit wait.
 * 
 * @author nitish
 *
 */

public class E_ExplicitWaitsAndFindElements {
	C_InvokeChrome invokeChrome = new C_InvokeChrome();

	public static void main(String[] args) throws MalformedURLException {
		E_ExplicitWaitsAndFindElements explicitWaitsAndFindElements = new E_ExplicitWaitsAndFindElements();
		explicitWaitsAndFindElements.waitsAndAssertions();
	}

	private void waitsAndAssertions() throws MalformedURLException {
		WebDriver driver = invokeChrome.launch();

		System.out.println("Avoid Thread.sleep, instead use explicit wait concept of selenium, this will check every 250ms for the condition specified using ExpectedCondition");
		WebDriverWait wait=new WebDriverWait(driver, 5);
		
		System.out.println("identifying element by its unique id");
		By radioLoc=By.id("radiobutton");
		
		System.out.println("wait for its presence in DOM");
		wait.until(ExpectedConditions.presenceOfElementLocated(radioLoc));
		
		System.out.println("identifying element by its uique name");
		By checkbox= By.name("selected(1234)");
		
		System.out.println("wait for element to be visible on page");
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
		
		System.out.println("idenitfying element by its class");
		System.out.println("Make sure from firebug that its uniquely identified");
		By headingLoc= By.className("mainheading");
		
		System.out.println("wait for text within a given element");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(headingLoc, "Selenium: Beginners Guide"));
		
		System.out.println("Expected Exception on Failure");
		
		try{
			wait.until(ExpectedConditions.textToBePresentInElementLocated(headingLoc, "Selenium: ffffBeginners Guide"));
			
		}
		finally{
			invokeChrome.quit(driver);
		}
		
	}

}
