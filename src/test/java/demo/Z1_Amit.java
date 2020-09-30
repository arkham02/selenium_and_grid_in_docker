package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.regex.Pattern;

public class Z1_Amit {
    public static void main(String[] args) throws MalformedURLException {

        C_InvokeChrome chrome= new C_InvokeChrome();
        WebDriver driver = chrome.launch();

        try {
            driver.get("https://airstack-qa.lenovosoftware.com");
            Wait wait = new WebDriverWait(driver, 40);


            driver.findElement(By.id("mat-input-0")).sendKeys("auto4390@gmail.com");
            sleep(1);
            driver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
            driver.findElement(By.name("password")).sendKeys("Asdf@12345");
            sleep(1);
            driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='AUTORG']")));

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("(//mat-icon[text()='menu'])[1]")));
            sleep(1);
            driver.findElement(By.xpath("//*[contains(text(),'SERVICE CENTER')]")).click();
            sleep(1);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//mat-spinner")));

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("(//mat-icon[text()='menu'])[1]")));
            sleep(1);
            driver.findElement(By.xpath("//*[contains(text(),'WORKSPACE')]")).click();
            sleep(1);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//mat-spinner")));

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("(//mat-icon[text()='menu'])[1]")));
            sleep(1);
            driver.findElement(By.xpath("//*[contains(text(),'CONTRIBUTION REPORT')]")).click();
            sleep(1);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//mat-spinner")));


            sleep(2);

            boolean handleFound = false;
            for (int i = 1; i <=10; i++) {
                for(String handle : driver.getWindowHandles()){
                    if (driver.switchTo().window(handle).getTitle().contains("Airstack Report")) {
                        handleFound = true;

                        break;
                    }
                    driver.switchTo().defaultContent();
                }

                if(handleFound) break;
                sleep(1);
            }

            if(!handleFound) throw new RuntimeException("No matching handle");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Contributions') and contains(text(),'Dashboard')]")));



            wait.until(ExpectedConditions.textMatches
                    (By.xpath("//*[contains(text(),'Stacks') and contains(text(),'Created')]//following-sibling::div[@name='cbeventname']"),
                     Pattern.compile("\\d+")));
            WebElement stacksCreated = driver.findElement(By.xpath("//*[contains(text(),'Stacks') and contains(text(),'Created')]//following-sibling::div[@name='cbeventname']"));
            System.out.println("Stacks created:"  + stacksCreated.getText());

            driver.switchTo().defaultContent();


        }
        finally {
            sleep(5);
            chrome.quit(driver);
        }


    }

    public static void sleep(int sec){

        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
