package demo;

import java.time.Duration;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lnkedinpost {
    WebDriver driver;
    public Lnkedinpost(){
System.out.println("Constructor: TestCases Linkedinpost");
WebDriverManager.chromedriver().timeout(30).browserVersion("116.0.5845.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: Closed Linkedinpost");
        driver.close();
        driver.quit();
    }
    public void post() throws InterruptedException{
        System.out.println("Start Test case: Linkedinpost");
        driver.get("https://www.linkedin.com/");
	    //Dummy email
        driver.findElement(By.id("session_key")).sendKeys("username.com");
	    //dummy password
		driver.findElement(By.id("session_password")).sendKeys("password@111");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        Thread.sleep(3000);
        WebElement who = driver.findElement(By.xpath("(//span/strong)[1]"));
        System.out.println("Who's viewed your profile? : " + who.getText());
        WebElement impression = driver.findElement(By.xpath("(//span/strong)[2]"));
        System.out.println("Impressions of your post? : " + impression.getText());
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class, 'artdeco-entity-lockup__title ember-view')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//p)[1]")).sendKeys("Opportunities don't happen, you create them.");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);
        
        WebElement msg = driver.findElement(By.xpath("//span[text()='Post successful.']"));
        System.out.println("Post is successful?: " + msg.isDisplayed());
        
        driver.findElement(By.xpath("//a[text()='View post']")).click();
        Thread.sleep(3000);
        
        WebElement afterpost = driver.findElement(By.xpath("//section[@class='fixed-full']"));
        try {
        if(afterpost.isDisplayed())
        	System.out.println("The post is posted and visible");
        }
        catch(Exception ex)
        {
        System.out.println("FileformatException => " + ex.getMessage());
        }
    }
}
