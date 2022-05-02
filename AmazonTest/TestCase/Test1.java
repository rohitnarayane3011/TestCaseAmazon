package AmazonTest.TestCase;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Test1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.edge.driver", "C:\\SeleniumDriver\\edge\\msedgedriver.exe");
		WebDriver driver;
		driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		getallLinks(driver);

	}

	public static void getallLinks(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='Let Us Help You']")).isDisplayed();
		ArrayList<String> xpathlist = new ArrayList<>();
		xpathlist.add("//a[text()='COVID-19 and Amazon']");
		xpathlist.add("//a[text()='Your Account']");
		xpathlist.add("//a[text()='Returns Centre']");
		xpathlist.add("//a[text()='100% Purchase Protection']");
		xpathlist.add("//a[text()='Amazon App Download']");
		xpathlist.add("//a[text()='Help']");
		for (int i = 0; i < xpathlist.size(); i++) {
			CovidLink(xpathlist.get(i), driver);
		}

	}

	public static void CovidLink(String linkName, WebDriver driver) {

		String s = driver.findElement(By.xpath(linkName)).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(s);
		String Title = driver.getTitle();
		System.out.println(Title);
		// switch tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
	}

}
