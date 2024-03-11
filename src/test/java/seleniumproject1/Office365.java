package seleniumproject1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Office365 {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.office.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='mectrl_header_text mectrl_truncate']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kalyan@cloudfuze.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Onedrive@2409");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id=\"idSIButton9\"]")).click();
		
		

	}

}


/*//driver.switchTo().defaultContent();
//driver.switchTo().frame("signInFrame");
WebElement pavan = driver.findElement(By.cssSelector(".signInFrame"));
//System.out.print(pavan);
driver.switchTo().frame(pavan);

driver.findElement(By.className("form-group col-md-12 placeholderContainer")).sendKeys("max@snapbot.io");
//driver.findElement(By.xpath("//*[@class='form-group col-md-12 placeholderContainer']//input[not(@type='hidden')]")).sendKeys("max@snapbot.io");
//driver.findElement(By.xpath("//input[@type='submit']")).click();
*/