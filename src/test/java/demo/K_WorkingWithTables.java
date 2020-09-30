package demo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class K_WorkingWithTables {
	C_InvokeChrome invokeChrome = new C_InvokeChrome();

	public static void main(String[] args) {
		K_WorkingWithTables k_WorkingWithTables = new K_WorkingWithTables();
		k_WorkingWithTables.elementsInteraction();
	}

	private void elementsInteraction() {

		WebDriver driver = invokeChrome.launch();
		System.out.println("navigate to a different page");
		driver.navigate().to("http://toolsqa.com/automation-practice-table/");

		System.out.println("Get the table element");
		WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']"));

		System.out.println("Listing table headers");
		List<WebElement> tableHeaders = table.findElements(By.xpath("./thead//th"));
		for (WebElement tableHeader : tableHeaders) {
			System.out.print(tableHeader.getText() + "\t");
		}
		System.out.println();
		System.out.println("Listing contents of first row");
		List<WebElement> tableRowFirst = table.findElements(By.xpath("./tbody/tr[1]//th"));
		for (WebElement tableCells : tableRowFirst) {
			System.out.print(tableCells.getText() + "\t");
		}

		System.out.println("Finding the Rank of Click Tower Hotel");

		System.out.println("Finding the rank index");

		int rankIndex = 0;
		boolean bRankIndexFound = false;

		for (WebElement tableHeader : tableHeaders) {
			rankIndex++;

			if (tableHeader.getText().equals("Rank")) {
				bRankIndexFound = true;
				break;
			}
		}

		assertTrue("Rank column must be present", bRankIndexFound);
		System.out.println("rank Index is :-" + rankIndex);

		WebElement rank = driver.findElement(
				By.xpath("//th[text()='Clock Tower Hotel']//following-sibling::td[" + (rankIndex - 1) + "]"));
		System.out.println("Rank is:-" + rank.getText());

		invokeChrome.quit(driver);

	}

}
