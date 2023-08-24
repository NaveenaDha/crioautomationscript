package demo;

import java.time.Duration;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nestedframe {

WebDriver wb;
    public Nestedframe(){
System.out.println("Constructor: TestCases Nestedframe");
        WebDriverManager.chromedriver().timeout(30).browserVersion("116.0.5845.0").setup();
        wb = new ChromeDriver();
        wb.manage().window().maximize();
        wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: Closed Nestedframe");
        wb.close();
        wb.quit();
    }
    public void nsframe(){
        System.out.println("Start Test case: Nestedframe");

        wb.get("https://the-internet.herokuapp.com/nested_frames");
        //wb.switchTo().frame(0);
        //Switch to the top frame
        wb.switchTo().frame("frame-top");

        // Switch to the middle frame
        wb.switchTo().frame("frame-left");

        // Get the text from the middle frame
        WebElement LeftFrame = wb.findElement(By.tagName("body"));
        String LeftFrameText = LeftFrame.getText();
        System.out.println("The text of frame left: " + LeftFrameText);

        // Switch back to the default content
        wb.switchTo().parentFrame();

        // Switch to the left frame
        wb.switchTo().frame("frame-middle");

        // Get the text from the left frame
        WebElement MiddleFrame = wb.findElement(By.tagName("body"));
        String MiddleFrameText = MiddleFrame.getText();
        System.out.println("The text of frame middle: " + MiddleFrameText);

        // Switch back to the default content
        wb.switchTo().parentFrame();

        // Switch to the bottom frame
        wb.switchTo().frame("frame-right");

        // Get the text from the bottom frame
        WebElement RightFrame = wb.findElement(By.tagName("body"));
        String RightFrameText = RightFrame.getText();
        System.out.println("The text of frame right: " + RightFrameText);

        // Switch back to the default content
        wb.switchTo().defaultContent();
        
        wb.switchTo().frame("frame-bottom");

        // Get the text from the bottom frame
        WebElement bottomFrame = wb.findElement(By.tagName("body"));
        String bottomFrameText = bottomFrame.getText();
        System.out.println("The text of frame bottom: " + bottomFrameText);
    }
    }
    
