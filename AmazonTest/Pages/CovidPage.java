package AmazonTest.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

public class CovidPage {
	WebDriver driver;

	public CovidPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 */
	public String VerifyCovid() {
		String s = driver.findElement(By.xpath("//a[text()='COVID-19 and Amazon']")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(s);
		String covidTitle = driver.getTitle();
		System.out.println("The Title is " + covidTitle);
		
		// switch tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		
		return covidTitle;

	}
}
