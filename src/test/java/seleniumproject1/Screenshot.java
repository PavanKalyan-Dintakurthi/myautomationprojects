package seleniumproject1;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver abc = new ChromeDriver();
		
		abc.get("https://www.youtube.com/watch?v=ky0plZ8GRmU&ab_channel=SDET-QA");
		abc.manage().window().maximize();
		//abc.manage().timeouts().implicitlyWait(10, Timeunit.SECONDS)
		Thread.sleep(15);
		//abc.findElement(By.xpath("//video[@class='video-stream html5-main-video']").click();
		Actions actions = new Actions(abc);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(15000);
	  TakesScreenshot ts=(TakesScreenshot)abc;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File trg = new File(".\\screenshots\\youtube page3.png");
	  
	
	  FileUtils.copyFile(src,trg);
	  
	  TakesScreenshot image=abc.findElement(By.xpath("//a[@class='yt-simple-endpoint style-scope ytd-video-owner-renderer']//img[@id='img']"));
	  File src1 = image.getScreenshotAs(OutputType.FILE);
	  File trg1 = new File(".\\screenshots\\image.png");
	  FileUtils.copyFile(src1,trg1);
	  
	}

}
