package objs;


import org.openqa.selenium.WebDriver;


public class ShopHome {

	public static final String HOME_URL = "http://automationpractice.com/index.php";

	 // Method to open HomePage
	public static void openPage(WebDriver wd) {
		wd.get(HOME_URL);
	}

	 // Method to navigate to HomePage if other page is opened
	public static void navigateToPage(WebDriver wd) {
		wd.navigate().to(HOME_URL);
	}

}
