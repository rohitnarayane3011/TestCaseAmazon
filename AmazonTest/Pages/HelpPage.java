package AmazonTest.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class HelpPage {
	WebDriver driver;
	public HelpPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * link = the parameters used by store a link(URL)
	 * HelpPageTitle = get a page title
	 * tabs = get a all tabs in getWindowHandles 
	 * @return = HelpPageTitle, return a page title
	 */
	public String VerifyHelpPage() {
		String link = driver.findElement(By.xpath("//a[text()='Help']")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);
		String HelpPageTitle = driver.getTitle();
		System.out.println("The Title is " + HelpPageTitle);
		// switch tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		return HelpPageTitle;

	}

}
