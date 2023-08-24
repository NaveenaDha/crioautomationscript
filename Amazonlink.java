package demo;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Keys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Amazonlink {
    WebDriver driver;
    public Amazonlink(){
        System.out.println("Constructor: TestCases Amazonlink");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: Closed Amazonlink");
        driver.close();
        driver.quit();

    }

    public void searchAmazon() throws InterruptedException{
        System.out.println("Start Test case: Amazonlink");
        //Navigate to google.com
        driver.get("https://www.google.com");
        System.out.println("Opened Google Page");
        // Enter amazon in search bar Using Locator "XPath" //textarea[@id='APjFqb'] | sendKeys("Amazon")
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).clear();
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Amazon");

        // In search bar, press enter key Using Locator "XPath" //textarea[@id='APjFqb'] | sendKeys(Keys.RETURN)
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        // Verify whether amazon.in or amazon.com link present in the page Using Locator "XPath" //span[@class='x2VHCd OSrXXb ob9lvb']
WebElement amzonname = driver.findElement(By.xpath("(//span[@class='OSrXXb'])[1]"));
if(amzonname.isDisplayed())
{
    System.out.println("The Amazon link is available in search result");
}
}
    
}
