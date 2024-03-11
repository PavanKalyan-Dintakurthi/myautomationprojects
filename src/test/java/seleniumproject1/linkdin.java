package seleniumproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linkdin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://play1.automationcamp.ir/advanced.html");
		
		String abc =driver.findElement(By.xpath("(//label[@class='star-rating'])[1]")).getText();
		System.out.print(abc);
	}

}
