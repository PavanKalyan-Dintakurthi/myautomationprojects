package seleniumproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Onedrive {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://onedrive.live.com/login/");
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("signInFrame");
		WebElement pavan = driver.findElement(By.cssSelector(".signInFrame"));
		//System.out.print(pavan);
		driver.switchTo().frame(pavan);
		
		driver.findElement(By.className("form-group col-md-12 placeholderContainer")).sendKeys("max@snapbot.io");
		//driver.findElement(By.xpath("//*[@class='form-group col-md-12 placeholderContainer']//input[not(@type='hidden')]")).sendKeys("max@snapbot.io");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		

	}

}
