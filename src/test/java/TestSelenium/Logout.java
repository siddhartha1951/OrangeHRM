package TestSelenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends Implementation{
	//7 Logging out of the website
    public void logOut() throws IOException {
    	
    	WebElement profile = driver.findElement(By.xpath("//span[@class = 'oxd-userdropdown-tab']//i")); // Click on the Profile Picture Dropdown
    	profile.click();
   
    	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();		// Click on the Logout button
    	
    	String file=System.getProperty("user.dir")+"//Test_Data//testexcel.xlsx";
    	String baseURL = ExcelUtils.getCellData(file, "Sheet1", 1, 0);
    	
    	//Checking if the Log out is successful
    	
    	if(driver.getCurrentUrl().equals(baseURL)) {
    		// Write the result in testexcel.xlsx, Sheet3
			ExcelUtils.setCellData(file, "Sheet1", 1, 2, "Passed/Logged Out");
			ExcelUtils.fillGreenColor(file, "Sheet1", 1, 2);		
		}else {
			// Write the result in testexcel, Sheet3
			ExcelUtils.setCellData(file, "Sheet1", 1, 2, "Failed/Unable to Logout");
			ExcelUtils.fillRedColor(file, "Sheet1", 1, 2);
		}
    	
    }
}
