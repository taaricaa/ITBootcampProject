package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShopDresses {

	WebDriver driver = new ChromeDriver();

	public static String SUMMER_DRESSES_PAGE = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static final String WOMEN_BTN = "//a[@class='sf-with-ul'][contains(text(),'Women')]"; 
	public static final String SUMMER_DRESSES1 = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";// xpath
	public static final String DRESSES_BTN = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]";// xpath
	public static final String SUMMER_DRESSES2 = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]"; // apsxpath

	 // Method to back to HomePage
	public static void BackToHome(WebDriver wd) {
		wd.navigate().back();
	}

	 // Method to get current URL
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
     // Method to go to summer dresses page via women button
	public static void goToSummerPage1(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(By.xpath(WOMEN_BTN));
		action.moveToElement(elem).perform();
		driver.findElement(By.xpath(SUMMER_DRESSES1)).click();

	}
	
     // Method to go to summer dresses page via dresses button
	public static void goToSummerPage2(WebDriver driver) {
		Actions action2 = new Actions(driver);
		WebElement elem2 = driver.findElement(By.xpath(DRESSES_BTN));
		action2.moveToElement(elem2).perform();
		driver.findElement(By.xpath(SUMMER_DRESSES2)).click();

	}

}
