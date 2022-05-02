package AmazonTest.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class AppDownloadPage {
	WebDriver driver;

	public AppDownloadPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * link = the parameters used by store a link(URL)
	 * AppDownloadTitle = get a page title
	 * tabs = get a all tabs in getWindowHandles 
	 * @return = AppDownloadTitle, return a page title
	 */
	public String VerifyAppDownload() {
		String link = driver.findElement(By.xpath("//a[text()='Amazon App Download']")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);
		String AppDownloadTitle = driver.getTitle();
		System.out.println("The Title is " + AppDownloadTitle);
		// switch tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		return AppDownloadTitle;
	}
}
