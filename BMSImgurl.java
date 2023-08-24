package demo;

import java.time.Duration;
import java.util.List;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BMSImgurl {
    WebDriver driver;
    public BMSImgurl(){
System.out.println("Constructor: TestCases BMSImgurl");
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
public void imageurl() throws InterruptedException{
    driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // Find and print image URLs for Recommended Movies
        List<WebElement> recommendedMovies = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div//div[contains(@class, 'YeNog')]/div"));
        for (WebElement movieContainer : recommendedMovies) {
                String imageUrl = movieContainer.getAttribute("src");
                System.out.println("Image URL: " + imageUrl);
            }
//<-- This site is blocked by client not to automate -->

        // Thread.sleep(3000);
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("window.scrollBy(0,1000)", "");
		// Thread.sleep(10000);
		// //WebDriverWait wait = new WebDriverWait (driver, 100);
		// driver.findElement(By.xpath("//h2[text() ='Premieres']/../../../following-sibling::div/div/div/div[2]/a/div/div[3]")); 
        // String premiereName = driver.findElement(By.xpath(".//div[@class='sc-7o7nez-0 iHsoLV']")).getText();
        // String premiereLanguage = driver.findElement(By.xpath(".//div[@class='sc-7o7nez-0 kHxEsI']")).getText();
        // System.out.println(premiereName);
        // System.out.println(premiereLanguage);
}

}
