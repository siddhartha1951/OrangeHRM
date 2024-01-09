package DriverSetup;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Driver {
	public static WebDriver driver;
	
	
	//To call different browsers
	public void driverSetup(int choice)
	{
		switch(choice) {
		case 1: 
			driver = new ChromeDriver(); //Launch Chrome Browser
			break;
		case 2:
			driver = new EdgeDriver();  // Launch Edge Browser
			break;
		case 3:
			System.out.println("Program Closed");
			System.exit(0);
			break;
		default:
			System.out.println("Correct option not selected...!!");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
