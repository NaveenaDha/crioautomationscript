package demo;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertprompt {
    WebDriver driver;
    public Alertprompt(){
        System.out.println("Constructor: TestCases AlertPrompt");
        WebDriverManager.chromedriver().timeout(30).browserVersion("116.0.5845.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: Closed BMSImgurl");
        driver.close();
        driver.quit();
    }    

    public void AlertPrompt() throws InterruptedException{
driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(2000);
	
        Alert alert = driver.switchTo().alert();
		alert.sendKeys("NaveenaDharani");
		alert.accept();
	
		Thread.sleep(2000);
		WebElement result = driver.findElement(By.xpath("//p[contains(text(),'NaveenaDharani')]"));
        if(result.isDisplayed())
        {
        	System.out.println("Text is available");
        }else
        {
        	System.out.println("Not found");
        }
		System.out.println(result.getText());


        
    }
}
