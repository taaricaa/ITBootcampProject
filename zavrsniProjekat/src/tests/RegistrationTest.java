
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objs.Login;
import objs.ShopRegistration;
import utils.ShopMain;

import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {
	WebDriver driver;
	Actions action;
	SoftAssert sa;
	WebElement we;

	@BeforeClass
	public void beforeClass() {
		ShopMain.getFile(ShopMain.excellPath);
		ShopMain.getSheet(0);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		// action = new Actions(driver);
		sa = new SoftAssert();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Test to check Sign up process
	@Test(priority = 1)
	public void testLogin() {
		driver.get(ShopRegistration.LOGIN);
		ShopRegistration.testUserRegister(driver);
		sa.assertAll();
	}

	// Test to check if user is signed in
	@Test(priority = 2)
	public void testLoginCheck() throws InterruptedException {
		ShopRegistration.myaccount(driver);
		String CURRENT_URL = driver.getCurrentUrl();
		sa.assertEquals(CURRENT_URL, ShopRegistration.MY_ACCOUNT);
		sa.assertAll();
		Login.signOut(driver);
	}

	// Test to register 30 Users from file "persons.xlsx"
	@Test(priority = 3)
	public void reg30Test() {
		objs.Login.backToLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		for (int i = 1; i <= 30; i++) {
			ShopRegistration.regUser(driver, i);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			we = driver.findElement(By.xpath(ShopRegistration.USER));
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			sa.assertEquals(we.getText(), ShopMain.getDataAt(i, 2) + " " + ShopMain.getDataAt(i, 3));
			Login.signOut(driver);
		}
		sa.assertAll();
	}

	// Test to check login for 30 Users from file "persons.xlsx"
	@Test(priority = 4)
	public void test30UsersLogin() {
		Login.backToLogin(driver);
		
		for (int i = 1; i <= 30; i++) {
			Login.login(driver, i);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			sa.assertTrue(driver.findElement(By.xpath(Login.SIGN_OUT)).isDisplayed());
			Login.signOut(driver);
		}
		sa.assertAll();

	}
}
