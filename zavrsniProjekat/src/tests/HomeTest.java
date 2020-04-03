package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import objs.ShopHome;
import utils.ShopMain;

public class HomeTest {
	WebDriver wd;
	Actions action;
	SoftAssert sa;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		wd = new ChromeDriver();
		action = new Actions(wd);
		sa = new SoftAssert();
		ShopMain.getFile(ShopMain.excellPath);
		ShopMain.getSheet(0);

	}

	// Test to check if HomePage is opened
	@Test
	public void openHomePage() {
		wd.get(ShopHome.HOME_URL);
		String CURRENT_URL = wd.getCurrentUrl();
		sa.assertEquals(CURRENT_URL, "http://automationpractice.com/index.php");
		sa.assertAll();
	}

}
