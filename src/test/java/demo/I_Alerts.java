package demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class I_Alerts {
	C_InvokeChrome invokeChrome = new C_InvokeChrome();

	public static void main(String[] args) throws InterruptedException {
		I_Alerts i_Alerts = new I_Alerts();
		i_Alerts.handleAlerts();
	}

	private void handleAlerts() throws InterruptedException {

		WebDriver driver = invokeChrome.launch();
		
		System.out.println("navigating to a different page");
		driver.navigate().to("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		System.out.println("Click to launch the confirm alert box");
		WebElement ele_confirmPopUpButton =driver.findElement(By.xpath("//button [text()='Confirm Pop up']"));
		ele_confirmPopUpButton.click();
		
		System.out.println("wait until alert appears");
		wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println("to perform operations on alert we have to switch driver to it");
		Alert alert= driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		System.out.println("Click on OK - use the accept command");
		alert.accept();
		
		System.out.println("verify span tag post accept");
		WebElement ele_confirmPopUpSpan = driver.findElement(By.id("ConfirmOption"));
		assertThat("Post accpet verify text", ele_confirmPopUpSpan.getText(), equalTo("You have clicked on OK"));
		
		invokeChrome.quit(driver);
		
	}
	
}
