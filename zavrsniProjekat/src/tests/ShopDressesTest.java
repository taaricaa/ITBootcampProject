package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objs.ShopDresses;
import objs.ShopHome;

public class ShopDressesTest {
	WebDriver driver;
	Actions action;
	SoftAssert sa;
	String url1;
	String url2;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		sa = new SoftAssert();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	 // Test to go to summer dresses page via Women button
	@Test
	public void test1() { 
		ShopHome.openPage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement we1 = driver.findElement(By.xpath(ShopDresses.WOMEN_BTN));

		action.moveToElement(we1).perform();

		driver.findElement(By.xpath(ShopDresses.SUMMER_DRESSES1)).click();
		url1 = driver.getCurrentUrl();
		sa.assertEquals(url1, "http://automationpractice.com/index.php?id_category=11&controller=category");
		sa.assertAll();
	}
	
     //Test to go to summer dresses page via Dresses button 
	@Test
	public void test2() { // odlazak sa dresses_btn na summer_dresses i provera url-a
		ShopDresses.BackToHome(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement we1 = driver.findElement(By.xpath(ShopDresses.DRESSES_BTN));

		action.moveToElement(we1).perform();

		driver.findElement(By.xpath(ShopDresses.SUMMER_DRESSES2)).click();
		url2 = driver.getCurrentUrl();
		sa.assertEquals(url2, "http://automationpractice.com/index.php?id_category=11&controller=category");
		sa.assertAll();
		
	}
     //Test to compare URL-s   
	@Test
	public void test3() { // uporedjivanje summer dresses url-a do koga se doslo na prethodna dva nacina
		sa.assertEquals(url1, url2);
		sa.assertAll();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
