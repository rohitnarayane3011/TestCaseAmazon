package AmazonTest.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class PurchaseProtectionPage {
	WebDriver driver;

	public PurchaseProtectionPage(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * link = the parameters used by store a link(URL)
	 * purchaseProtection = get a page title
	 * tabs = get a all tabs in getWindowHandles 
	 * @return = purchaseProtection, return a page title
	 */
	public String VerifyPurchaseProtection() {
		String link = driver.findElement(By.xpath("//a[text()='100% Purchase Protection']")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);
		String purchaseProtection = driver.getTitle();
		System.out.println("The Title is " + purchaseProtection);
		// switch tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		return purchaseProtection;
	}

}
