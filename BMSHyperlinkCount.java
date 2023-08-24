package demo;

import java.time.Duration;
import java.util.List;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BMSHyperlinkCount {
    WebDriver driver;
    public BMSHyperlinkCount(){
        System.out.println("Constructor: TestCases BMSHyperlinkCount");
        WebDriverManager.chromedriver().timeout(30).browserVersion("116.0.5845.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: Closed BMSHyperlinkCount");
        driver.close();
        driver.quit();
    }

public void HyperlinkCountBMS(){
System.out.println("Start Test case: BMSHyperlinkCount");
// Navigate to https://in.bookmyshow.com/explore/home/chennai  
driver.get("https://in.bookmyshow.com/explore/home/chennai");
// Find all the hyperlinks Using Locator "XPath" //a
List<WebElement> count = driver.findElements(By.xpath("//a"));

// Count the number of hyperlinks  .size()
System.out.println("The count of BookMyShow Hyperlink is : " + count.size());

// Verify the hyperlink count  359
int expected = 359;
if(count.size() == expected)
{
System.out.println("The Hyperlink count is as expected " + expected);
}else
{
    System.out.println("The Actual count is " + count.size());
}
}
}
