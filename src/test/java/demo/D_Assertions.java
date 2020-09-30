package demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This code snippet demonstrates commonly used assertion techniques
 * 
 * @author nitish
 *
 */
public class D_Assertions {
	C_InvokeChrome invokeChrome=new C_InvokeChrome();
	
	public static void main(String[] args) {
		D_Assertions assertions=new D_Assertions();
		assertions.waitsAndAssertions();
	}
	
	public void waitsAndAssertions()  {
		WebDriver driver = invokeChrome.launch();
		
		System.out.println("Finding radio button element with its unique html id ");
		WebElement radio = driver.findElement(By.id("radiobutton"));
		
		System.out.println("Finding all the html element which have tag name as input");
		List<WebElement> inputElements= driver.findElements(By.tagName("input"));
		
		System.out.println("Finding textbox using xpath and attributes");
		WebElement textbox = driver.findElement(By.xpath("//*[@contenteditable='true']"));
		
		System.out.println("Extract text from textbox");
		String textBoxContent = textbox.getText();
		
		String actualPageTitle=driver.getTitle();
		// CoreMatchers - equalTo
		System.out.println("assert page titile for exact match using hamcrest asserts");
		assertThat("The page title must be as expected",actualPageTitle, equalTo("Selenium: Beginners Guide"));
		
		// CoreMatchers - containsString
		System.out.println("assert page titile for partial match using hamcrest asserts");
		assertThat("The page title must be as expected",actualPageTitle, containsString(("Selenium: Beginners")));
		
		// assertTrue
		System.out.println("assert radio button is not hidden");
		assertTrue("Radio button must be displayed on the page", radio.isDisplayed());
		
		
		System.out.println("assert text box content for exact match");
		assertThat("Text Box content must be as expected",textBoxContent, equalTo("To be used after the AJAX section of the book"));
		
		//assertThat takes any argument , but they must be of same data type
		System.out.println("assert the total number of input elements on the page");
		assertThat("Total number of input elements must match",inputElements.size(), equalTo(6));
		
		System.out.println("Close all windows opened via selenium");
		
		invokeChrome.quit(driver);
		
	}
}
