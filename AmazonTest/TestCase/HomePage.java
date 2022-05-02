package AmazonTest.TestCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import AmazonTest.Pages.AppDownloadPage;
import AmazonTest.Pages.AssistantDownloadPage;
import AmazonTest.Pages.CovidPage;
import AmazonTest.Pages.HelpPage;
import AmazonTest.Pages.PurchaseProtectionPage;
import AmazonTest.Pages.ReturnsCentrePage;
import AmazonTest.Pages.YourAccountPage;

public class HomePage {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\SeleniumDriver\\edge\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		// Creating object of CovidPage
		CovidPage covidPage = new CovidPage(driver);
		// Creating object of YourAccountPage
		YourAccountPage yourAccountPage = new YourAccountPage(driver);
		// Creating object of ReturnsCentrePage
		ReturnsCentrePage returnsCentrePage = new ReturnsCentrePage(driver);
		// Creating object of PurchaseProtectionPage
		PurchaseProtectionPage purchaseProtectionPage = new PurchaseProtectionPage(driver);
		// Creating object of AppDownloadPage
		AppDownloadPage appDownloadPage = new AppDownloadPage(driver);
		// Creating object of AssistantDownloadPage
		AssistantDownloadPage assistantDownloadPage = new AssistantDownloadPage(driver);
		// Creating object of HelpPage
		HelpPage helpPage = new HelpPage(driver);

		// verify CovidPage
		String resultCovid = covidPage.VerifyCovid();
		// verify title
		Assert.assertEquals("FAQs about Orders and Deliveries and the COVID-19 virus - Amazon Customer Service",
				resultCovid);

		// verify CovidPage
		String AccountPageTitle = yourAccountPage.VerifyAccountPage();
		// verify title
		Assert.assertEquals("Your Account", AccountPageTitle);

		// verify CovidPage
		String purchaseProtection = returnsCentrePage.VerifyReturnsCentre();
		// verify title
		Assert.assertEquals("Amazon Sign In", purchaseProtection);

		// verify CovidPage
		String returnsCentreTitle = purchaseProtectionPage.VerifyPurchaseProtection();
		// verify title
		Assert.assertEquals("100% Purchase Protection - Amazon Customer Service", returnsCentreTitle);

		// verify CovidPage
		String appDownloadTitle = appDownloadPage.VerifyAppDownload();
		// verify title
		Assert.assertEquals("Amazon.in: Amazon Shopping App", appDownloadTitle);

		// verify CovidPage
		String assistantDownloadPageTitle = assistantDownloadPage.VerifyAssistantDownloadPage();
		// verify title
		Assert.assertEquals("404 - Document Not Found", assistantDownloadPageTitle);

		// verify CovidPage
		String helpPageTitle = helpPage.VerifyHelpPage();
		// verify title
		Assert.assertEquals("Help - Amazon Customer Service", helpPageTitle);

	}

}
