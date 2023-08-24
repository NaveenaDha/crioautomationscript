package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
// import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

    WebDriver driver;
    public WindowHandle(){
        System.out.println("Constructor: TestCases WindowHandle");
        WebDriverManager.chromedriver().timeout(30).browserVersion("116.0.5845.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: Closed WindowHandle");
        driver.close();
        driver.quit();
    }
public void Whandle() throws IOException, InterruptedException{
    System.out.println("Windows handle test case started");
    	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open"); 
		driver.manage().window().maximize();
//        wb.navigate().refresh();
		driver.switchTo().frame("iframeResult");
		//WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
		WebElement trybn = driver.findElement(By.xpath("//button[text()='Try it']"));
		trybn.click();
		
		String originalWindowHandle = driver.getWindowHandle();
		
		for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
		}
		//wb.navigate().to("https://www.w3schools.com/");
		System.out.println("The current URL is : " + driver.getCurrentUrl());
		System.out.println("The title is : " + driver.getTitle());
		//Take Screenshot
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        AShot ashot = new AShot();
        Screenshot screenshot = ashot.takeScreenshot(driver);
        String filename = "Screenshot " + timeStamp + ".png";
        ImageIO.write(screenshot.getImage(), "PNG", new File(filename));
            System.out.println("Full page screenshot capture and saved at: " + filename);
            driver.close();
            driver.switchTo().window(originalWindowHandle);}
    
}
