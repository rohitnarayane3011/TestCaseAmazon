package AmazonTest.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class YourAccountPage {
	WebDriver driver;

	public YourAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	
	/**
	 * link = the parameters used by store a link(URL)
	 * AccountPageTitle = get a page title
	 * tabs = get a all tabs in getWindowHandles 
	 * @return = AccountPageTitle, return a page title
	 */
	public String VerifyAccountPage() {
		String link = driver.findElement(By.xpath("//a[text()='Your Account']")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);
		String AccountPageTitle = driver.getTitle();
		System.out.println("The Title is " + AccountPageTitle);
		// switch tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		return AccountPageTitle;

	}
}
