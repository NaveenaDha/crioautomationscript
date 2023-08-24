package demo;

import java.time.Duration;
import java.util.List;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBratings {

    
WebDriver wb;
    public IMDBratings(){
System.out.println("Constructor: TestCases IMDBratings");
WebDriverManager.chromedriver().timeout(30).browserVersion("116.0.5845.0").setup();
        wb = new ChromeDriver();
        wb.manage().window().maximize();
        wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: Closed IMDBratings");
        wb.close();
        wb.quit();
    }

public void Rating() throws InterruptedException{

    System.out.println("Start Test case: IMDBratings");
       wb.get("https://www.imdb.com/chart/top/");
		WebElement hr = wb.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]"));
		String txt = hr.getText();
		System.out.println("The highest rated movie on IMDb: " + txt);
		List<WebElement> num = wb.findElements(By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']"));
        System.out.println(num.size() + " movies are included in the table");
		Select select = new Select(wb.findElement(By.id("sort-by-selector")));
		select.selectByVisibleText("Release date");
		Thread.sleep(4000);
		WebElement wb1 = wb.findElement(By.xpath("(//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[250]/div/a/h3"));
		WebElement wb3 = wb.findElement(By.xpath("(//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[1]/div/a/h3"));
		if(wb1.isDisplayed())
		{
			String txt1 = wb1.getText();
			System.out.println("The oldest movie on the list : " + txt1);
		}
		if(wb3.isDisplayed())
		{
			String txt2 = wb3.getText();
			System.out.println("The recent movie on the list : " + txt2);
		}
		select.selectByIndex(3);
		System.out.println(txt + " movie has the most user ratings");
		
	}
}
    

