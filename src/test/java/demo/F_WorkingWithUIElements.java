package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This code snippet demonstrates interaction with different html elements using selenium
 * 
 * @author nitish
 *
 */
public class F_WorkingWithUIElements {
	C_InvokeChrome invokeChrome = new C_InvokeChrome();

	public static void main(String[] args) {
		F_WorkingWithUIElements workingWithUIElements = new F_WorkingWithUIElements();
		workingWithUIElements.elementsInteraction();
	}

	public void elementsInteraction() {

		WebDriver driver = invokeChrome.launch();

		System.out.println("get the radio button. Same html element can be identified using different locators");
		WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio']"));

		System.out.println("Check if radio button is already selected");
		if (!radioButton.isSelected()) {
			System.out.println("Radio button is not checked.");
			radioButton.click();
		}

		System.out.println("get the drop down");
		Select select = new Select(driver.findElement(By.id("selecttype")));

		System.out.println("Select an option from dropdown text ");
		select.selectByVisibleText("Selenium Core");

		System.out.println("Get currently selected drop down option");
		WebElement selectedElement = select.getFirstSelectedOption();
		System.out.println("Currently selected dropdown option is:" + selectedElement.getText());

		System.out.println("select checkbox");
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}

		System.out.println("Get the textbox html element");
		WebElement textBox = driver.findElement(By.xpath("//*[@contenteditable='true']"));

		System.out.println("clear the text box");
		textBox.clear();

		System.out.println("enter text into the text box");
		textBox.sendKeys("Winter is coming !");

		System.out.println("Click button");
		WebElement loadTextToPageButton = driver.findElement(By.id("secondajaxbutton"));
		loadTextToPageButton.click();

		System.out.println("verify text in textbox");
		String textContent = textBox.getText();

		System.out.println("Text content after clicking the text button:-" + textContent);

		System.out.println("Close all windows opened via selenium");
		invokeChrome.quit(driver);
	}
}
