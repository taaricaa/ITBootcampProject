package objs;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ShopMain;

public class ShopRegistration {

	public static String LOGIN = "http://automationpractice.com/index.php?controller=my-account";
	public static String MY_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
	public static final String LOGOUT = "//a[@class='logout']";
	public static final String CONTROL_LOGIN = "//a[@class='login']";
	public static final String EMAIL = "//input[@id='email_create']";
	public static final String CREATE_ACCOUNT = "//button[@id='SubmitCreate']";
	public static final String FIRST_NAME = "//input[@id='customer_firstname']";
	public static final String LAST_NAME = "//input[@id='customer_lastname']";
	public static final String PASS = "//input[@id='passwd']";
	public static final String ADDRESS = " //input[@id='address1']";
	public static final String CITY = "//input[@id='city']";
	public static final String STATE = "//option[contains(text(),'Hawaii')]";
	public static final String POSTALCODE = "//input[@id='postcode']";
	public static final String COUNTRY = "//option[contains(text(),'United States')]";
	public static final String MOB = "//input[@id='phone_mobile']";
	public static final String REGISTER = "//span[contains(text(),'Register')]";
	public static final String MYACCOUNT = "//a[@class='account']";
	public static final String USER = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]/span[1]";

	// Method to set random e-mail
	public static void inputemail(WebDriver driver) {
		WebElement elem = driver.findElement(By.xpath(EMAIL));
		elem.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(30);
		elem.sendKeys("linalala" + randomInt + "@gmail.com");
	}

	 // Method to set e-mail
	public static void inputEmail(WebDriver wd, String email) {
		wd.findElement(By.xpath(EMAIL)).sendKeys(email);

	}

	// Method to click on create account button
	public static void clickCreateAccount(WebDriver driver) {
		driver.findElement(By.xpath(CREATE_ACCOUNT)).click();
	}

	// Method to set First name
	public static void inputFirstName(WebDriver driver, String firstname) {
		WebElement elem = driver.findElement(By.xpath(FIRST_NAME));
		elem.sendKeys(firstname);
	}

	// Method to set Last name
	public static void inputLastName(WebDriver driver, String lastname) {
		WebElement elem = driver.findElement(By.xpath(LAST_NAME));
		elem.sendKeys(lastname);
	}

	// Method to set Password
	public static void inputPass(WebDriver driver, String password) {
		WebElement elem = driver.findElement(By.xpath(PASS));
		elem.sendKeys(password);
	}

	// Method to set Address
	public static void inputAddress(WebDriver driver, String address) {
		WebElement elem = driver.findElement(By.xpath(ADDRESS));
		elem.sendKeys(address);
	}

	// Method to set City
	public static void inputCity(WebDriver driver, String city) {
		WebElement elem = driver.findElement(By.xpath(CITY));
		elem.sendKeys(city);
	}

	// Method to choose State
	public static void state(WebDriver driver) {
		driver.findElement(By.xpath(STATE)).click();
	}

	// Method to set Postal code
	public static void inputPostalcode(WebDriver driver, String postalcode) {
		WebElement elem = driver.findElement(By.xpath(POSTALCODE));
		elem.sendKeys(postalcode);
	}

	// Method to choose Country
	public static void country(WebDriver driver) {
		driver.findElement(By.xpath(COUNTRY)).click();
	}

	// Method to set phone
	public static void inputMob(WebDriver driver, String mob) {
		WebElement elem = driver.findElement(By.xpath(MOB));
		elem.sendKeys(mob);
	}

	// Method to click on register button
	public static void clickRegBtn(WebDriver driver) {
		driver.findElement(By.xpath(REGISTER)).click();

	}

	// Method to logout
	public static void logout(WebDriver driver) {
		driver.findElement(By.xpath(LOGOUT)).click();
	}

	// Method to click on My account button
	public static void myaccount(WebDriver driver) {
		driver.findElement(By.xpath(MYACCOUNT)).click();
	}

	// Method for registration
	public static void testUserRegister(WebDriver driver) {

		inputemail(driver);
		clickCreateAccount(driver);
		inputFirstName(driver, "Tamara");
		inputLastName(driver, "Stanisic");
		inputPass(driver, "12345");
		inputAddress(driver, "Palm street");
		inputCity(driver, "Honolulu");
		state(driver);
		inputPostalcode(driver, "38271");
		country(driver);
		inputMob(driver, "45345345453");

		clickRegBtn(driver);

	}
     // Method for registration 30 users from persons.xlsx file
	public static void regUser(WebDriver driver, int i) {

		inputEmail(driver, ShopMain.getDataAt(i, 1));
		clickCreateAccount(driver);
		inputFirstName(driver, ShopMain.getDataAt(i, 2));
		inputLastName(driver, ShopMain.getDataAt(i, 3));
		inputPass(driver, ShopMain.getDataAt(i, 4));
		inputAddress(driver, ShopMain.getDataAt(i, 5));
		inputCity(driver, ShopMain.getDataAt(i, 6));
		state(driver);
		inputPostalcode(driver, ShopMain.getDataAt(i, 8));
		country(driver);
		inputMob(driver, ShopMain.getDataAt(i, 9));

		clickRegBtn(driver);
	}

	public static void regUsers(WebDriver driver, int i) {

		for (i = 1; i <= 30; i++) {
			if (!Login.signOut(driver)) {
				Login.signOut(driver);
			}
			regUser(driver, i);
		}
	}

}
