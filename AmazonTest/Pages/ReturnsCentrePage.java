package AmazonTest.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class ReturnsCentrePage {
	WebDriver driver;

	public ReturnsCentrePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * link = the parameters used by store a link(URL)
	 * ReturnsCentreTitle = get a page title
	 * tabs = get a all tabs in getWindowHandles 
	 * @return = ReturnsCentreTitle, return a page title
	 */
	public String VerifyReturnsCentre() {
		String link = driver.findElement(By.xpath("//a[text()='Returns Centre']")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);
		String ReturnsCentreTitle = driver.getTitle();
		System.out.println("The Title is " + ReturnsCentreTitle);
		// switch tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		return ReturnsCentreTitle;
	}
}
