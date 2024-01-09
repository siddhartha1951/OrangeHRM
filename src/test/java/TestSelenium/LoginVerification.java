package TestSelenium;

import java.io.IOException;

import org.openqa.selenium.By;

public class LoginVerification extends Implementation{
	
	// Method to do Login operation
	public void logIn() throws IOException{
		 String file=System.getProperty("user.dir")+"//Test_Data//testexcel.xlsx";
		 String username = ExcelUtils.getCellData(file, "Sheet2", 1, 0);  // Read Username from testexcel.xlsx, Sheet2
		 String password = ExcelUtils.getCellData(file, "Sheet2", 1, 1);  // Read Password from testexcel.xlsx, Sheet2
		 
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username); // Username
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password); // Password
		 
		 //Login Button click
		 driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	 	
		}
		
		// Method to Verify the URL
    public void verifyURL() throws IOException, InterruptedException {
    	 Thread.sleep(2300);
    	 ScreenshotScroll.screenshot("SS1");
    	 String file=System.getProperty("user.dir")+"//Test_Data//testexcel.xlsx";
		 String validation = ExcelUtils.getCellData(file, "Sheet2", 1, 2); // Read "dashboard" from testexcel.xlsx, Sheet2
		 
		 // Validation if "dashboard" is present in the URL
		 
		 if(driver.getCurrentUrl().contains(validation)) {
			 System.out.println("Valid URL");
			 
			 // Write the result in testexcel.xlsx , Sheet2
			 ExcelUtils.setCellData(file, "Sheet2",1,3,"Passed");
			 ExcelUtils.fillGreenColor(file, "Sheet2",1,3);
		 }else {
			 System.out.println("Not Valid URL");
			 
			// Write the result in testexcel.xlsx , Sheet2
			 ExcelUtils.setCellData(file, "Sheet2",1,3,"Failed");
			 ExcelUtils.fillRedColor(file, "Sheet2",1,3);
			 
		 	}
	    }
}
