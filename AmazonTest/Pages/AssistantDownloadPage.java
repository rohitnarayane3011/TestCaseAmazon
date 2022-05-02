package AmazonTest.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class AssistantDownloadPage {
	WebDriver driver;

	public AssistantDownloadPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * link = the parameters used by store a link(URL)
	 * AssistantDownloadPageTitle = get a page title
	 * tabs = get a all tabs in getWindowHandles 
	 * @return = AssistantDownloadPageTitle, return a page title
	 */
	public String VerifyAssistantDownloadPage() {
		String link = driver.findElement(By.xpath("//a[text()='Amazon Assistant Download']")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);
		String AssistantDownloadPageTitle = driver.getTitle();
		System.out.println("The Title is " + AssistantDownloadPageTitle);
		// switch tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		return AssistantDownloadPageTitle;

	}
}
