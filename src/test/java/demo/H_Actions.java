package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class H_Actions {
	C_InvokeChrome invokeChrome = new C_InvokeChrome();

	public static void main(String[] args) throws InterruptedException {
		H_Actions h_Actions = new H_Actions();
		h_Actions.performActions();
	}

	private void performActions() throws InterruptedException {

		WebDriver driver = invokeChrome.launch();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		System.out.println("Navigate to a different page");

		driver.navigate().to("http://store.demoqa.com/");

		WebDriverWait wait = new WebDriverWait(driver, 5);

		Actions actions = new Actions(driver);

		WebElement element = driver.findElement(By.linkText("Product Category")); // for anchor tags <@>


		actions.moveToElement(element).build().perform();

		driver.findElement(By.linkText("iPads")).click();

		wait.until(ExpectedConditions.titleContains("iPads | ONLINE STORE"));

		invokeChrome.quit(driver);
	}
}
