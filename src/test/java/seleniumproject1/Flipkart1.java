package seleniumproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart1 {


	public static void main(String args[]) throws Exception {

		//Launching of Chrome Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");	
		driver.manage().window().maximize();

		//Verifying loaded page was amazon or not
		Boolean image =driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
		if(image=true)
		{
			System.out.println("logged in amazon successfully");
		}

		//Searching for Laptop
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Laptop");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);

		//Selecting an item in the loaded list of options
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]")).click();

		//Handling windows as the selected item was loading in new tab
		Set<String> window_ids = driver.getWindowHandles();

		List <String>windowidsList=new ArrayList<String>(window_ids); 

		String parentWindowID=windowidsList.get(0);
		String childWindowID=windowidsList.get(1);

		driver.switchTo().window(childWindowID);

		String device_name = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
		//System.out.println(device_name);

		Thread.sleep(2000);
		//Adding selected item into cart
		driver.findElement(By.xpath("(//input[@value='Add to Cart'])[2]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='a-button a-button-base attach-button-large attach-cart-button']")).click();


		String in_cart_item_name=driver.findElement(By.xpath("//span[@class='a-truncate sc-grid-item-product-title a-size-base-plus']")).getText();
		System.out.println(in_cart_item_name);

		//verifying added item in cart and choosed item are same or not
		if(device_name.contains(in_cart_item_name))
		{
			System.out.println("Added item in the cart and choosed item in list was same");
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();

		Thread.sleep(3000);

		//Loging into the Amazon account
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kalyan.cloudfuze@gmail.com");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@2024");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		//Switching to main page to verify the logged account was correct or not
		driver.switchTo().window(parentWindowID);
		driver.navigate().refresh();

		Thread.sleep(3000);
		String account_name = driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).getText();		

		if(account_name.equals("Hello, Testing"))
		{
			System.out.println("Loggedin correct account");
		}

		driver.switchTo().window(childWindowID);
		Thread.sleep(3000);

		//Adding address to deliver the product( Verifying whether given address was already present or not)
		Boolean address_name=driver.findElement(By.xpath("(//span[@class='break-word'])[1]")).isDisplayed();
		//System.out.println(address_name);
		if(address_name==true)
		{
			driver.findElement(By.xpath("//input[@data-testid='Address_selectShipToThisAddress']")).click();
		}

		else {
			driver.findElement(By.xpath("//a[@id='add-new-address-popover-link']")).click();	

			WebElement drpCountryEle=driver.findElement(By.xpath("//select[@name='address-ui-widgets-countryCode']"));
			Select drpCountry=new Select(drpCountryEle);

			// Selecting an option from the dropdown
			drpCountry.selectByVisibleText("India");

			driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys("Automation QA Engineer");

			driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("9394602316");

			driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("520012");

			driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("FlatNo:101,HouseNo:2-8-16,RAMA Enclave,");

			driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']")).sendKeys("Sitara center,Vidhyadharapuram");

			driver.findElement(By.xpath("//input[@id='address-ui-widgets-landmark']")).sendKeys("Near Masjid");

			driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']")).clear();
			driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']")).sendKeys("Vijayawada");

			WebElement drpStateEle=driver.findElement(By.xpath("//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']"));
			Select drpState=new Select(drpStateEle);

			// Selecting an option from the dropdown
			drpState.selectByVisibleText("ANDHRA PRADESH");

			driver.findElement(By.xpath("//span[@class='a-button a-button-primary']")).click();
		}

		Thread.sleep(7000);
		//Choosing the type of payment
		driver.findElement(By.xpath("(//input[@name='ppw-instrumentRowSelection'])[3]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter UPI ID']")).sendKeys("9394602316@ybl");
		driver.findElement(By.xpath("//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'])[1]")).click();

		Thread.sleep(9000);

		//Verifying choosed item from list and item in reviews order section are same
		boolean offers = driver.findElement(By.xpath("//span[@id='prime-interstitial-nothanks-button']")).isDisplayed();

		if (offers=true)
		{
			driver.findElement(By.xpath("//span[@id='prime-interstitial-nothanks-button']")).click();
		}
		Thread.sleep(6000);
		String finalreview = driver.findElement(By.xpath("//div[@class='a-row breakword']")).getText();
		System.out.println(finalreview);

		if(device_name.equals(finalreview))
		{
			System.out.println("Reviewed in the product adding cart is successful");
		}	 
	}
}
