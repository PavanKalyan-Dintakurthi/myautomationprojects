package seleniumproject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		// to select "mobiles under 15000" option from the autosuggestions
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("mobiles ");
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[text()='under 15000']")).click();
		 
		 WebElement element = driver.findElement(By.xpath("//*[text()='Clock Speed']"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(element);
		 actions.perform();
		 //to select pie option
		 driver.findElement(By.xpath("//*[text()='Operating System Version Name']")).click();
		 actions.moveToElement(element);
		 actions.perform();
		 driver.findElement(By.xpath("//*[text()='11 MORE']")).click();
		 actions.moveToElement(element);
		 actions.perform();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[text()='Pie']")).click();
		 Thread.sleep(2000);
		 
		 //to drag the price bar to 10000
		 WebElement slider2 = driver.findElement(By.xpath("//div[@class='_31Kbhn WC_zGJ']"));
         actions.dragAndDropBy(slider2, -180, 0).build().perform();
         driver.findElement(By.xpath("//*[text()='Newest First']")).click();
         Thread.sleep(2000);

         
         //to get the names of the first five mobiles
		 List<WebElement> listofmobiles = driver.findElements(By.xpath("//*[@class='_4rR01T']"));
		 //System.out.print(listofmobiles.size());
		 for(int i=0; i<5; i++){
			
		 System.out.println(listofmobiles.get(i).getText());
   	    }
		 //to get the prices of first five mobiles
		 List<WebElement> priceofmobiles = driver.findElements(By.xpath("//*[@class='_30jeq3 _1_WHN1']"));
		 for(int i=0; i<5; i++){
			
		 System.out.println(priceofmobiles.get(i).getText());
   	    }
		 
		 //verification of first value price
		 String gt = driver.findElement(By.xpath("//*[@class='_30jeq3 _1_WHN1']")).getText();
		 String at=gt.replaceAll("₹","" ).replaceAll(",","");
         String total_Amt=at.toString();
         System.out.println(total_Amt);
         int total_amt_val =Integer.parseInt(total_Amt);
         if(total_amt_val<30000) {
         System.out.println("lesser than 30000");}
		 
		 driver.close();
	
	}

}
