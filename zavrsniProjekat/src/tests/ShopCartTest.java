package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objs.ShopCart;

public class ShopCartTest {
	WebDriver driver;
	SoftAssert sa;

	@BeforeClass
	public void before() {
		driver = new ChromeDriver();
		sa = new SoftAssert();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
      //Test to add to cart dresses
	@Test
	public void order() throws InterruptedException {

		driver.get("http://automationpractice.com/index.php?id_category=11&controller=category");
		ShopCart.buyDress(driver);
		Thread.sleep(2000);
		sa.assertEquals(driver.findElement(By.xpath("//span[@id='layer_cart_product_title']")).getText(),
				"Printed Summer Dress");
		sa.assertEquals(driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText(), "2");
		sa.assertTrue(
				driver.findElement(By.xpath("//span[@id='layer_cart_product_attributes']")).getText().contains("M"));
		sa.assertTrue(
				driver.findElement(By.xpath("//span[@id='layer_cart_product_attributes']")).getText().contains("Blue"));

		sa.assertAll();

	}
      // Test to check if we added two blue M size dresses
	@Test
	public void proceed() throws InterruptedException {

		driver.get("http://automationpractice.com/index.php?id_product=5&controller=product#/color-blue/size-m");
		ShopCart.checkProceed(driver);

		sa.assertAll();

	}

}
