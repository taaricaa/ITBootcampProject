package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopCart {

	public static final String BUY_BTN = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']//span[@class='availability']//span[1]";
	public static final String FIRST_DRESS = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']//a[@class='product-name'][contains(text(),'Printed Summer Dress')]";
	public static final String SIZE_M = "//option[contains(text(),'M')]";
	public static final String BLUE = "//a[@id='color_14']";
	public static final String ADD_MORE = "//i[@class='icon-plus']";
	public static final String ADD_TO_CART = "//span[contains(text(),'Add to cart')]";
	public static final String PROCEED = "//span[contains(text(),'Proceed to checkout')]";
	public static final String PROCEED2 = "//a[@class='button btn btn-default standard-checkout button-medium']";

	 // Method to add to cart dress
	public static void buyDress(WebDriver driver) {
		driver.findElement(By.xpath(FIRST_DRESS)).click();
		driver.findElement(By.xpath(ADD_MORE)).click();
		driver.findElement(By.xpath(SIZE_M)).click();
		driver.findElement(By.xpath(BLUE)).click();
		driver.findElement(By.xpath(ADD_TO_CART)).click();
	}

	 // Method to proceed from add to cart dress to sign in
	public static void checkProceed(WebDriver driver) { //
        driver.findElement(By.xpath(PROCEED)).click();
		driver.findElement(By.xpath(PROCEED2)).click();

	}

}
