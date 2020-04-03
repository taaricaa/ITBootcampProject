package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ShopMain;

public class Login {

	public static final String LOGIN = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static final String SIGN_OUT = "//a[@class='logout']";
	static final String SIGN_IN = "//p[@class='submit']//span[1]";
	private static final String EMAIL = "//input[@id='email']";
	private static final String PASS = "//input[@id='passwd']";

	public static void goToLogin(WebDriver driver) {
		driver.get(LOGIN);
	}

	public static void backToLogin(WebDriver driver) {
		driver.navigate().to(LOGIN);
	}

	public static void login(WebDriver driver, int i) {
		driver.findElement(By.xpath(EMAIL)).sendKeys(ShopMain.getDataAt(i, 1));
		driver.findElement(By.xpath(PASS)).sendKeys(ShopMain.getDataAt(i, 4));
		driver.findElement(By.xpath(SIGN_IN)).click();
	}

	public static boolean signOut(WebDriver driver) {
		if (driver.findElement(By.xpath(SIGN_OUT)).isDisplayed()) {
			driver.findElement(By.xpath(SIGN_OUT)).click();
		}
		return true;
	}

}
